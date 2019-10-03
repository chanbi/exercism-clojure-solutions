(ns rna-transcription)

(defn to-rna [dna]
  {:pre [(string? dna) (re-matches #"[ACGT]*" dna)]
   :post [(string? %)]}
  (let [swap {\G \C
              \C \G
              \T \A
              \A \U}]
    (apply str (map #(get swap %) dna))))
