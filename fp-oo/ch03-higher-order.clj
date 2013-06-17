; Exercise 01
(def inc-2
  (map (partial + 2) [1 2 3]))

(def inc-2-variant
  (map (comp inc inc) [1 2 3]))

; Exercise 02
(def separate (juxt filter remove))

; Exercise 04
(def myfun
  ((fn [x] 
     (fn [] x))
     3))
