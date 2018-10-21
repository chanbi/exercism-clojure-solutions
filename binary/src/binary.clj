(ns binary)

(defn bin-digits [string] 
  (map #({\0 0 \1 1} % 0) string)) 

(defn to-decimal [string]
  (reduce #(+ (* 2 %1) %2) 0 (bin-digits string)))
