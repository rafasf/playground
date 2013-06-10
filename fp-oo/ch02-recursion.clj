; Exercise 1
(def factorial
  (fn [n]
    (if (= 1 n)
      n
      (* n (factorial (dec n))))))
