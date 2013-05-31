(def factorial
  (fn [number]
    (apply * (range 1 (inc number)))))
