(load-file "src/ch03-scheduling.clj")

; Exercise 01
;; Sample data
;; [{ :course-name "zig" :morning? true :limit 4 :registered 0 } { :course-name "zag" :morning false :limit 4 :registered 0 } ])
;; { :manager? true }
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


; Exercise 02
;; Sample data
;; [{ :course-name "zig" :morning? true :limit 4 :registered 0 :prerequisite ["zag"] } { :course-name "zag" :morning false :limit 4 :registered 0 :prerequisite ["another"] } ])
;; { :manager? true :previously-taken ["zag"] }
(def note-unavailability
  (fn [courses instructor-count registrants]
    (let [out-of-instructors?
          (= instructor-count
             (count (filter (fn [course] (not (empty? course)))
                            courses)))]
      (map (fn [course]
             (assoc course
                    :unavailable? (or (:full? course)
                                      (and out-of-instructors?
                                           (:empty? course))
                                      (and (:manager? registrants)
                                           (not (:morning? course)))
                                      (not (superset? (set (:previously-taken registrants))
                                                      (set (:prerequisite course)))))))
                    courses))))

(def annotate
  (fn [courses registrants instructor-count]
    (-> courses
      (answer-annotations registrants)
      domain-annotations
      (note-unavailability instructor-count registrants))))
