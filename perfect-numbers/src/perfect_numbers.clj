(ns perfect-numbers)

(defn- factors [number]
  (filter #(zero? (rem number %)) (range 1 number)))

(defn aliquot-sum [number]
  (reduce + (factors number)))

(defn classify [number]
  (if (pos? number)
    (cond
      (= (aliquot-sum number) number) :perfect
      (> (aliquot-sum number) number) :abundant
      :else :deficient)
    (throw (IllegalArgumentException.))))
