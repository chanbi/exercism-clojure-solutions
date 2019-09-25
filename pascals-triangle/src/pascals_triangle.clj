(ns pascals-triangle)

(def triangle
  ((fn build [row]
     (let [next-row (concat [1] (map + row (rest row)) [1])]
       (lazy-seq (cons row (build next-row)))))
   '(1)))

(defn row [number]
  {:pre [(number? number)]
   :post [(sequential? %) (= (reduce + %) (int (Math/pow 2 (dec number))))]}
  (nth triangle (dec number)))
