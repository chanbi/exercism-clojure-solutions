(ns nth-prime)

(defn- prime? [number]
  (if (< number 2)
    false
    (let [end (inc (Math/floor (Math/sqrt number)))]
      (not-any? #(zero? (rem number %)) (range 2 end)))))

(defn nth-prime [number]
  {:pre [(number? number)]
   post [(number? %)]}
  (if (pos? number)
    (nth (filter prime? (range)) (dec number))
    (throw (IllegalArgumentException.))))
