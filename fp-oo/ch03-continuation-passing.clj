; Exercise 01
(def c1
  (-> (concat '(a b c) '(d e f))
  ((fn [l]
     (-> (count l)
       ((fn [n]
          (odd? n))))))))
