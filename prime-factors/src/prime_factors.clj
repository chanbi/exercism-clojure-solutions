(ns prime-factors)

(defn of [number]
  {:pre [(number? number)]
   post [(seq? %) (= (reduce * %) number)]}
  (loop [divisor 2 result number prime-factors []]
    (if (< result 2)
      prime-factors
      (if (zero? (rem result divisor))
        (recur divisor (/ result divisor) (conj prime-factors divisor))
        (recur (inc divisor) result prime-factors)))))
