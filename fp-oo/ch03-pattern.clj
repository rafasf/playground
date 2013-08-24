(use 'patterned.sweet)

; Exercise 01
(defpatterned count-seq
  [so-far []] so-far
  [so-far [head & tail]] (count-seq (inc so-far) tail)
  [a-seq] (count-seq 0 a-seq))

; Exercise 02
(defpatterned pattern-reduce
  [func so-far []] so-far
  [func so-far [head & tail]] (pattern-reduce func (func so-far head) tail))
