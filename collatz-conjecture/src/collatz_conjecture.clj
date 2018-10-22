(ns collatz-conjecture)

(defn- calculate [num]
  (if (even? num) (/ num 2) (inc (* num 3))))

(defn collatz [num]
  {:pre [(> num 0)]}
  (count (take-while #(> % 1) (iterate calculate num))))
