(ns in-clj.weather
  (:require [in-clj.munging :refer :all]))

(defn to-day-weather [line]
  {:day (int-between 0 4 line)
   :max (int-between 6 8 line)
   :min (int-between 12 14 line)})

(defn days-weather-from [lines]
  (map to-day-weather lines))

(defn spread-of [day-weather]
  {:day (:day day-weather)
   :spread (- (:max day-weather) (:min day-weather))})

(defn lowest-spread-in [spreads]
  (lowest-of :spread spreads))
