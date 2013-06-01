(def Point
  (fn [x y]
    {:x x
     :y y
     :__class_symbol__ 'Point}))

(def x :x)
(def y :y)
(def class :__class_symbol__)

(def shift
  (fn [this xinc yinc]
    (Point (+ (:x this) xinc)
           (+ (:y this) yinc))))

(def Triangle
  (fn [point point2 point3]
    { :point1 point :point2 point2 :point3 point3
      :__class_symbol 'Triangle }))

;; Exercise 01
(def add
  (fn [point point2]
    (Point (+ (x point) (x point2))
           (+ (y point) (y point2)))))

(def add2
  (fn [point point2]
    (shift point (x point2) (y point2))))

;; Exercise 03
(def a
  (fn [thing & args]
    (apply thing args)))