(ns spiral-matrix)

(defn transpose [matrix]
  (apply map list matrix))

(defn rotate [matrix]
  (map reverse (transpose matrix)))

(defn spiral
  ([size] (if (zero? size) '() (spiral size size 1)))
  ([nrows ncols start]
   (if (zero? nrows)
     '(())
     (let [first-row (list (range start (+ start ncols)))
           inner-spiral (rotate (spiral ncols (dec nrows) (+ start ncols)))]
       (concat first-row inner-spiral)))))
