(ns in-clj.football-test
  (:require [midje.sweet :refer :all]
            [in-clj.football :refer :all]))

(def a-team "    1. Arsenal         38    26   9   3    79  -  36    87")
(def another-team "   18. Ipswich         38     9   9  20    41  -  64    36")
(def raw-data "Team            P     W    L   D    F      A     Pts
    1. Arsenal         38    26   9   3    79  -  36    87
   -------------------------------------------------------
   18. Ipswich         38     9   9  20    41  -  64    36")

(facts "about parsing"
 (fact "ignores lines without relevant data"
   (let [read-data (relevant-lines-in raw-data)]
     (count read-data) => 2
     (first read-data) => a-team
     (second read-data) => another-team)))


