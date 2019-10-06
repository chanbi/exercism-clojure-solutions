(ns isbn-verifier)

(def isbn-dgts {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9 \X 10})

(defn- filter-digits [isbn]
  (filter isbn-dgts isbn))

(defn- valid-digits? [isbn]
  (let [digits (filter-digits isbn)]
    (and (= 10 (count digits))
         (every? (dissoc isbn-dgts \X) %) (butlast digits))))

(defn- to-numbers [isbn]
  (map #(isbn-dgts %) isbn))

(defn isbn? [isbn]
  (if (valid-digits? isbn)
    (zero? (mod (reduce + (map-indexed #(* (inc %1) %2) (reverse (to-numbers (filter-digits isbn))))) 11))
    false))
