(ns beer-song (:require [clojure.string :as str]))

(defn verse
  "Returns the nth verse of the song."
  [nb]
  (let [bottle-s #(case % 0 "no more bottles" 1 "1 bottle" (str % " bottles"))
        one-it (if (> nb 1) "one" "it")]
    (cond
      (pos? nb) (str (bottle-s nb) " of beer on the wall, " (bottle-s nb) " of beer.\n"
                     "Take " one-it " down and pass it around, " (bottle-s (dec nb)) " of beer on the wall.\n")
      :else (str "No more bottles of beer on the wall, no more bottles of beer.\n"
                 "Go to the store and buy some more, 99 bottles of beer on the wall.\n"))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end] (str/join "\n" (map verse (range start (dec end) -1)))))
