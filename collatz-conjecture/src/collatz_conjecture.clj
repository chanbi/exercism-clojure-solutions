(ns collatz-conjecture)

(defn collatz [number]
  {:pre [(> number 0)]}
  (loop [count 0 num number]
    (if (= 1 num) count 
      (recur (inc count) (if (even? num) (/ num 2) (+ (* num 3) 1))))))  
