; Exercise 01
(def inc-this
  (fn [v]
    (-> v first inc list)))

; Exercise 02
(def inc-and-multiply
  (fn [v]
    (-> v first inc (* 3) list)))
