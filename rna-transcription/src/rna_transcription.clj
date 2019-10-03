(ns rna-transcription)

(defn- transcribe [char]
  (case char
    \C \G
    \G \C
    \A \U
    \T \A
    (throw (AssertionError.))))

(defn to-rna [dna]
  {:pre [(string? dna)]
   :post [(string? %)]}
  (apply str (map transcribe dna)))
