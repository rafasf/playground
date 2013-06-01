(load-file "src/ch02-barely-object.clj")

;; Exercise 01
(def add
  (fn [point point2]
    (Point (+ (x point) (x point2))
           (+ (y point) (y point2)))))

(def add2
  (fn [point point2]
    (shift point (x point2) (y point2))))

;; Exercise 02
(def a
  (fn [thing & args]
    (apply thing args)))

;; Exercise 03 & 04
(def equal-triangles? =)

;; Exercise 05
(def valid-triangle?
  (fn [& points]
    (= (distinct points) points)))
