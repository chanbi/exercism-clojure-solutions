(ns isbn-verifier)

(def isbn-dgts {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9 \X 10})

(defn- valid-pattern? [isbn]
  (re-matches #"^(\d)-?(\d{3})-?(\d{5})-?([\dX])$" isbn))

(defn- valid-formula? [numbers]
  (zero? (mod (reduce + (map * (range 10 -1 -1) numbers)) 11)))

(defn- to-numbers [isbn]
  (map #(isbn-dgts %) (filter isbn-dgts isbn)))

(defn isbn? [isbn]
  (and (valid-pattern? isbn) (valid-formula? (to-numbers isbn))))
