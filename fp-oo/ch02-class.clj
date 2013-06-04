(def method-of
  (fn [message class]
    (message (:__instance_methods__ class))))

(def class-of
  (fn [instance]
    (eval (:__class_symbol__ instance))))

(def apply-message-to
  (fn [class instance message args]
    (apply (method-of message class) instance args)))

(def a
  (fn [class & args]
    (let [seeded { :__class_symbol__ (:__own_symbol__ class) }]
      (apply-message-to class seeded :add-instance-values args))))

(def send-to
  (fn [instance message & args]
    (apply-message-to (class-of instance) instance message args)))

(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__
   {
    :class-name :__class_symbol__
    :class (fn [this] (class-of this))
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :shift (fn [this xinc yinc]
             (a Point (+ (:x this) xinc)
                      (+ (:y this) yinc)))
    }
})
