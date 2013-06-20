; Exercise 01
(def c1
  (-> (concat '(a b c) '(d e f))
  ((fn [l]
     (-> (count l)
       ((fn [n]
          (odd? n))))))))

; Exercise 03
(def c2
  (-> 3
    ((fn [n]
       (-> (+ n 2)
         ((fn [n2]
            (inc n2))))))))
