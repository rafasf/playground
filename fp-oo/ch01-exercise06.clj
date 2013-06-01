(def prefix-of?
  (fn [candidate a-seq]
    (= (take (count candidate) a-seq) candidate)))
