(ns pascals-triangle)

(def triangle (iterate #(lazy-cat [1] (mapv + % (rest %)) [1]) '(1)))

(defn row [number]
  {:pre [(number? number)]
   :post [(seq? %) (= (reduce + %) (int (Math/pow 2 (dec number))))]}
  (nth triangle (dec number)))
