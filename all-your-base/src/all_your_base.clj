(ns all-your-base)

(defn- base? [base] (> base 1))
(defn- digits? [digits base] (every? #(contains? (set (range base)) %) digits))

(defn to-base [number base]
  {:pre [(number? number) (base? base)]
   :post [(seq? %) (digits? % base)]}
  (cond (nil? number) '() (zero? number) '(0)
        :else (loop [digits '() num number]
                (if (zero? num) digits
                    (recur (cons (rem num base) digits)
                           (quot num base))))))

(defn to-decimal [digits base]
  {:pre [(seq? digits) (digits? digits base) (base? base)]
   :post [(number? %)]}
  (when (not (empty? digits)) (reduce #(+ (* base %1) %2) 0 digits)))

(defn convert [in-base digits out-base]
  (try (to-base (to-decimal digits in-base) out-base) (catch AssertionError e nil)))
