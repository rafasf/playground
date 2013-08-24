(use 'patterned.sweet)

(defpatterned count-seq
  [so-far []] so-far
  [so-far [head & tail]] (count-seq (inc so-far) tail)
  [a-seq] (count-seq 0 a-seq))
