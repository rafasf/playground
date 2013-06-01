(def tails
  (fn [seq]
    (map drop
         (range 0 (inc (count seq)))
         (repeat (inc (count seq)) seq))))
