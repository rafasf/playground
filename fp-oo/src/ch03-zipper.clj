(require '[clojure.zip :as zip])

(def zlog
     (fn [z] (println "LOG:" (pr-str (zip/node z))) z))

(def zuplog
     (fn [z] (zlog (zip/up z)) z))

(def flattenize
     (fn [tree]
       (letfn [(flatten-zipper [so-far zipper]
                 (cond (zip/end? zipper)
                       so-far
                       (zip/branch? zipper)
                       (flatten-zipper so-far (zip/next zipper))
                       :else
                       (flatten-zipper (cons (zip/node zipper) so-far)
                                       (zip/next zipper))))]
         (reverse (flatten-zipper '() (zip/seq-zip tree))))))

(def tumult
     (fn [form]
       (letfn [(helper [zipper]
                       (cond (zip/end? zipper)
                             zipper
                             (= (zip/node zipper) '+)
                             (-> zipper
                                 (zip/replace 'PLUS)
                                 zip/next
                                 helper)
                             (and (zip/branch? zipper)
                                  (= (-> zipper zip/down zip/node) '-))
                             (-> zipper
                                 (zip/append-child 55555)
                                 zip/next
                                 helper)
                             (and (zip/branch? zipper)
                                  (= (-> zipper zip/down zip/node) '*))
                             (-> zipper
                                 (zip/replace '(/ 1 (+ 3 (- 0 9999))))
                                 zip/next
                                 helper)
                             (= (zip/node zipper) '/)
                             (-> zipper
                                 zip/right
                                 zip/remove
                                 zip/right
                                 zip/remove
                                 (zip/insert-right (-> zipper zip/right zip/node))
                                 (zip/insert-right (-> zipper zip/right zip/right zip/node))
                                 zip/next
                                 helper)
                             :else
                             (-> zipper zip/next helper)))]
       (-> form zip/seq-zip helper zip/root))))
