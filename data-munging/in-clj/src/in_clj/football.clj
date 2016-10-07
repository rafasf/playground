(ns in-clj.football
  (:require [clojure.string :as str]))

(defn not-relevant [line]
  (re-matches #"^\d.*" (str/trim line)))

(defn relevant-lines-in [lines]
  (filter not-relevant (clojure.string/split-lines lines)))

(defn team-score-from [line]
  {:name (str/trim (subs line 7 23))
   :pro (read-string (subs line 43 45))
   :against (read-string (subs line 50 52))})

(defn teams-score-from [lines]
  (map team-score-from lines))
