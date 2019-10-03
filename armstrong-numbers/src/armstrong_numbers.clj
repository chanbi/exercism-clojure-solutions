(ns armstrong-numbers)

(defn power [num pow]
  (apply * (repeat pow num)))

(defn digits [num]
  (rseq (mapv #(mod % 10) (take-while pos? (iterate #(quot % 10) num)))))

(defn armstrong? [num]
  (def dgts (digits num))
  (= num (apply + (map #(power % (count dgts)) dgts))))
