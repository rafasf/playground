(def rrange
  (fn [first past-end]
    (new clojure.lang.LazySeq
         (fn []
           (if (= first past-end)
             nil
             (cons first (rrange (inc first) past-end)))))))

; Exercise 01
(def mmap
  (fn [func a-seq]
    (new clojure.lang.LazySeq
         (fn []
           (if (empty? a-seq)
             nil
             (cons (func (first a-seq))
                   (mmap func (rest a-seq))))))))

; Exercise 02
(def ffilter
  (fn [predicate? a-seq]
    (new clojure.lang.LazySeq
         (fn []
           (cond (empty? a-seq)
                 nil

                 (predicate? (first a-seq))
                 (cons (first a-seq)
                       (ffilter predicate? (rest a-seq)))

                 :else
                 (ffilter predicate? (rest a-seq)))))))
