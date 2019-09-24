(ns sum-of-multiples)

(defn sum-of-multiples [factors number]
  {:pre [(seq? factors) (number? number)]
   :post [(number? %)]}
  (reduce + (distinct (mapcat #(range 0 number %) factors))))
