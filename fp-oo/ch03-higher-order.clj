(load-file "src/ch03-higher-order.clj")

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

; Exercise 07
(def check-sum
  (fn [a-seq]
    (apply + (map * (range 1 (inc (count a-seq))) a-seq))))

; Exercise 08
(def isbn?
  (fn [isbn]
    (zero? (rem (check-sum (reversed-digits isbn)) 11))))
