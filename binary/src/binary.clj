(ns binary)

(defn bin-digits [string] 
  (map #({\0 0 \1 1} % 0) string))

(defn bin-power [index digit] 
  {:pre [(number? digit)]}
  (apply * digit (repeat index 2)))

(defn to-decimal [string]
  (apply + (map-indexed bin-power (reverse (bin-digits string)))))
