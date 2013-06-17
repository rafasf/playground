; Exercise 01
(def inc-2
  (map (partial + 2) [1 2 3]))

(def inc-2-variant
  (map (comp inc inc) [1 2 3]))
