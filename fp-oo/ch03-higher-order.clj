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
; (isbn? "0131774115")
; (isbn? "0977716614")
; (isbn? "1934356190")
(def isbn?
  (fn [isbn]
    (zero? (rem (check-sum (reversed-digits isbn)) 11))))

; Exercise 09
; (upc? "074182265830")
; (upc? "731124100023")
; (upc? "722252601404")
(def check-sum2
  (fn [a-seq]
    (apply + (map (fn [position digit] (* (if (odd? position) 1 3) digit)) (range 1 (inc (count a-seq))) a-seq))))

(def upc?
  (fn [upc]
    (zero? (rem (check-sum2 (reversed-digits upc)) 10))))

; Exercise 10
(def number-checker
  (fn [func divisor]
    (fn [a-seq]
      (let [numbers (reversed-digits a-seq)
            check-sum (apply + (map func (range 1 (inc (count numbers))) numbers))]
        (zero? (rem check-sum divisor))))))

(def isbn2? (number-checker * 11))
(def upc2? (number-checker (fn [position digit] (* (if (odd? position) 1 3) digit)) 10))

