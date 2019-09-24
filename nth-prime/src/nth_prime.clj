(ns nth-prime)

(defn- prime? [number]
  (if (< number 2)
    false
    (not-any? #(zero? (rem number %)) (range 2 number))))

(defn nth-prime [number]
  {:pre [(number? number)]
   post [(number? %)]}
  (if (pos? number)
    (last (take number (filter prime? (range))))
    (throw (IllegalArgumentException.))))
