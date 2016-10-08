(ns in-clj.munging
  (:require [clojure.string :as str]))

(defn not-relevant [line]
  (re-matches #"^\d.*" (str/trim line)))

(defn relevant-lines-in [lines]
  (filter not-relevant (clojure.string/split-lines lines)))

(defn string-between [start end string]
  (str/trim (subs string start end)))

(defn int-between [start end string]
  (read-string (string-between start end string)))

(defn lowest-of [a-key a-map]
  (first (sort-by a-key a-map)))

