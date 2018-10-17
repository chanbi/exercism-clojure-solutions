(ns binary)

(defn binary-power [pos digit] 
  (apply * digit (repeat pos 2)))

(defn number-else-zero [num] 
  (if (number? num) num 0))

(defn digits [string] 
    (map (comp number-else-zero read-string str) string))

; (read-string (str "2r" binary))
(defn to-decimal [binary]
  (apply + (map-indexed binary-power (reverse (digits binary)))))
  
