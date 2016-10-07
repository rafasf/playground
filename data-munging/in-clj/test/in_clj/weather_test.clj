(ns in-clj.weather-test
  (:require [midje.sweet :refer :all]
            [in-clj.weather :refer :all]))

(def a-day "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5")
(def another-day"  30  90    45    68          63.6       0.00 H       240  6.0 220  17  4.8 200 41 1022.7")
(def raw-data "Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP

   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5
  30  90    45    68          63.6       0.00 H       240  6.0 220  17  4.8 200 41 1022.7
  mo  82.9  60.5  71.7    16  58.8       0.00              6.9          5.3")

(facts "about parsing"
  (fact "ignores non-relevant lines"
    (let [valid-lines (relevant-lines-in raw-data)]
      (count valid-lines) => 2
      (first valid-lines) => a-day
      (second valid-lines) => another-day)))
