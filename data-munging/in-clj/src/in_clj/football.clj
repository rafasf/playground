(ns in-clj.football
  (:require [in-clj.munging :refer :all]))

(defn team-score-from [line]
  {:name (string-between 7 23 line)
   :pro (int-between 43 45 line)
   :against (int-between 50 52 line)})

(defn teams-score-from [lines]
  (map team-score-from lines))

(defn team-goal-different-of [team]
  {:name (:name team)
   :diff (- (:pro team) (:against team))})

(defn lowest-difference-in [teams]
  (lowest-of :diff teams))
