(load-file "src/ch03-zipper.clj")

; Exercise 01
(def all-vectors
  (fn [tree]
    (letfn [(all-from-zipper [so-far zipper]
              (cond (zip/end? zipper)
                    so-far
                    (zip/branch? zipper)
                    (all-from-zipper so-far (zip/next zipper))
                    (vector? (zip/node zipper))
                    (all-from-zipper (cons (zip/node zipper) so-far)
                                     (zip/next zipper))

                    :else
                    (all-from-zipper so-far (zip/next zipper))))]
      (reverse (all-from-zipper '() (zip/seq-zip tree))))))

; (all-vectors '(fn [a b] (concat [a] [b])))

; Exercise 02
(def first-vector
  (fn [tree]
    (letfn [(all-from-zipper [zipper]
              (cond (zip/end? zipper)
                    nil
                    (vector? (zip/node zipper))
                    (zip/node zipper)
                    :else
                    (all-from-zipper (zip/next zipper))))]
      (all-from-zipper (zip/seq-zip tree)))))

; (first-vector '(fn [a b] (concat [a] [b])))
