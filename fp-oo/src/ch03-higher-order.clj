(def reversed-digits
  (fn [string]
    (map (fn [digit-char]
           (-> digit-char str Integer.))
         (reverse string))))
