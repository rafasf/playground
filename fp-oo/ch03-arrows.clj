; Exercise 01
(def inc-this
  (fn [v]
    (-> v first inc list)))

; Exercise 02
(def inc-and-multiply
  (fn [v]
    (-> v first inc (* 3) list)))

; Exercise 03
(def by-2
  (fn [n]
    (-> n ((fn [n] (* 2 n))) inc)))

; Exercise 04
(def some-math
  (fn []
  (-> (+ 1 2) (* 3) (+ 4))))
