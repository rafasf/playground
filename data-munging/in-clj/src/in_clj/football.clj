(ns in-clj.football
  (:require [clojure.string :as str]))

(defn not-relevant [line]
  (re-matches #"^\d.*" (str/trim line)))

(defn relevant-lines-in [lines]
  (filter not-relevant (clojure.string/split-lines lines)))
