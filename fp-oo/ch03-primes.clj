(use 'clojure.algo.monads)

; Exercise 01
(def multiples
  (fn [n]
    (range (* n 2) 101 n)))

; Exercise 02
(def nonprimes
  (with-monad sequence-m
    (domonad [i (range 2 11)
              nonprime (multiples i)]
             nonprime)))

