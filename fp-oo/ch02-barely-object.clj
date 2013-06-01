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

(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))

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
