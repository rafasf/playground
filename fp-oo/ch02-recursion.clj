; Exercise 1
(def factorial
  (fn [n]
    (if (= 1 n)
      n
      (* n (factorial (dec n))))))

; Exercise 2
(def factorial-2
  (fn [n so-far]
    (if (= 1 n)
      so-far
      (factorial-2 (dec n) (* n so-far)))))

; Exercise 3
(def add-numbers
  (fn [numbers so-far]
    (if (empty? numbers)
      so-far
      (add-numbers (rest numbers) (+ (first numbers) so-far)))))
