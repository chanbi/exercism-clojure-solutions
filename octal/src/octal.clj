(ns octal)

(defn- to-digits [string]
  (let [oct-dgts {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7}]
    (when (every? oct-dgts string) (map #(oct-dgts %) string))))

(defn to-decimal [string]
  (reduce #(+ (* 8 %1) %2) 0 (to-digits string)))
