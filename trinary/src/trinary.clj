(ns trinary)

(defn- to-digits [string] 
  (let [tri-dgts {\0 0 \1 1 \2 2}]
    (when (every? #(contains? tri-dgts %) string) (map #(tri-dgts %) string))))
  
(defn to-decimal [string]
  (reduce #(+ (* 3 %1) %2) 0 (to-digits string)))
