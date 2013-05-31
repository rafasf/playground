(def add-squares
  (fn [& numbers]
    (apply + (map * numbers numbers))))
