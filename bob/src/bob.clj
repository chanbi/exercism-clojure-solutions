(ns bob (:require [clojure.string :as str]))

(defn yelling? [s]
  (and (= (str/upper-case s) s) (re-find #"[A-Z]" s)))

(defn question? [s]
  (= \? (last s)))

(defn response-for [s]
  (cond
    (str/blank? s) "Fine. Be that way!"
    (and (yelling? s) (question? s)) "Calm down, I know what I'm doing!"
    (yelling? s) "Whoa, chill out!"
    (question? s) "Sure."
    :else "Whatever."))
