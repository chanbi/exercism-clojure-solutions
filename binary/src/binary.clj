(ns binary)

(defn- to-digits [string] 
  (let [bin-dgts {\0 0 \1 1}]
    (when (every? bin-dgts string) (map #(bin-dgts %) string))))

(defn to-decimal [string]
  (reduce #(+ (* 2 %1) %2) 0 (to-digits string)))
