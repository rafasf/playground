(def send-to
  (fn [object message & args]
    (apply (message (:__methods__ object)) object args)))

(def Point
  (fn [x y]
    {:x x
     :y y
     :__class_symbol__ 'Point
     :__methods__ {
                   :x :x
                   :y :y
                   :class :__class_symbol__
                   :shift (fn [this xinc yinc]
                            (Point (+ (send-to this :x) xinc)
                                   (+ (send-to this :y) yinc)))
                   :add (fn [point point2]
                          (send-to point :shift (send-to point2 :x)
                                                (send-to point2 :y)))}}))
