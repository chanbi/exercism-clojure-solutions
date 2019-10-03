(ns reverse-string)

(defn reverse-string [s]
  (apply str (rseq (vec s))))
