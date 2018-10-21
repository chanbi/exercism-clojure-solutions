(ns all-your-base)

(defn to-base [number base]
  (if (nil? number) '()
    (if (zero? number) '(0)
      (loop [digits '() num number]
        (if (zero? num) digits
          (recur (conj digits (rem num base))
                (quot num base)))))))

(defn to-decimal [digits base]
  (if (empty? digits) nil 
    (apply + (map-indexed #(apply * %2 (repeat %1 base)) (reverse digits)))))

(defn valid-digits? [digits base]
  (every? #(and (not (neg? %)) (< % base)) digits))

(defn- convert-impl [in-base digits out-base] 
  {:pre  [(> in-base 1) (> out-base 1) (valid-digits? digits in-base)]
   :post [(valid-digits? % out-base)]}
  (to-base (to-decimal digits in-base) out-base))

(defn convert [in-base digits out-base] 
  (try (convert-impl in-base digits out-base) (catch AssertionError e nil)))
