(load-file "src/ch03-zipper.clj")

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
