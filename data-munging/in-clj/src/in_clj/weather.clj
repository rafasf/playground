(ns in-clj.weather
  (:require [clojure.string :as str]))

(defn not-relevant [line]
  (re-matches #"^\d.*" (str/trim line)))

(defn relevant-lines-in [lines]
  (filter not-relevant (clojure.string/split-lines lines)))

(defn to-day-weather [line]
  {:day (read-string (subs line 0 4))
   :max (read-string (subs line 6 8))
   :min (read-string (subs line 12 14))})

(defn days-weather-from [lines]
  (map to-day-weather lines))
