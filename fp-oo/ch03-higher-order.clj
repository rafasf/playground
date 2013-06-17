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

; Exercise 05
(def my-atom (atom 0))
(def change-atom
  (swap! my-atom (fn [anything] 33)))

; Exercise 06
(def a-value
  (fn [value]
    (fn [& anything] value)))
