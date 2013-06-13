(load-file "src/ch03-scheduling.clj")

(def note-unavailability
  (fn [courses instructor-count manager?]
    (let [out-of-instructors?
          (= instructor-count
             (count (filter (fn [course] (not (empty? course)))
                            courses)))]
      (map (fn [course]
             (assoc course
                    :unavailable? (or (:full? course)
                                      (and out-of-instructors?
                                           (:empty? course))
                                      (and manager?
                                           (not (:morning? course))))))
           courses))))

(def annotate
  (fn [courses registrants-courses instructor-count]
    (-> courses
      (answer-annotations registrants-courses)
      domain-annotations
      (note-unavailability instructor-count (:manager? registrants-courses)))))

