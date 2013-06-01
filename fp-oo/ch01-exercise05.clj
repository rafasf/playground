(def ready (list 2 10 5))
(def working (list 1 2 1))
(def blocked (list 3 1 3))

(def value-of-each
  (fn [index & lists]
    (flatten
      (map nth
           lists
           (repeat (count lists) index)))))

(def sum-of
  (fn [index]
    (apply + (value-of-each index ready working blocked))))

(def sum-highs (sum-of 0))
(def sum-mediums (sum-of 1))
(def sum-lows (sum-of 2))

