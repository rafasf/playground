(def apply-message-to
  (fn [class instance message args]
    (let [method (message (:__instance_methods__ class))]
      (apply method instance args))))

(def a
  (fn [class & args]
    (let [seeded { :__class_symbol__ (:__own_symbol__ class) }]
      (apply-message-to Point seeded :add-instance-values args))))

(def send-to
  (fn [instance message & args]
    (apply-message-to Point instance message args)))

(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__
   {
    :class :__class_symbol__
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :shift (fn [this xinc yinc]
             (a Point (+ (:x this) xinc)
                      (+ (:y this) yinc)))
    }
})
