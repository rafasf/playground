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

;; Exercise 01
(def add
  (fn [point point2]
    (Point (+ (x point) (x point2))
           (+ (y point) (y point2)))))

(def add2
  (fn [point point2]
    (shift point (x point2) (y point2))))
