(ns edn-csv
  (:require [clojure.edn :as edn]
            [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(def artworks (edn/read-string (slurp "resources/art.edn")))



(defn write-csv
  "Takes a file (path, name and extension) and
   csv-data (vector of vectors with all values) and
   writes csv file."
  [file csv-data]
  (with-open [writer (io/writer file)]
    (csv/write-csv writer csv-data)))

(defn maps->csv-data
  "Takes a collection of maps and returns csv-data (vector of vectors with all values)."
  [maps]
  (let [columns (-> maps first keys)
        headers (mapv name columns)
        rows (mapv #(mapv % columns) maps)]
    (into [headers] rows)))

(defn write-csv-from-maps
  "Takes a file (path, name and extension) and a collection of maps
   transforms data (vector of vectors with all values)
   writes csv file."
  [file maps]
  (->> maps maps->csv-data (write-csv file)))


(defn csv-data->maps
  "Originally from https://github.com/clojure/data.csv"
  [csv-data]
  (map zipmap
       (->> (first csv-data) ;; First row is the header
            (map keyword) ;; Drop if you want string keys instead
            repeat)
       (rest csv-data)))



(comment

  (spit "test.csv" (do (csv-data->maps (csv/read-csv (io/reader "resources/art.csv")))))

  (csv/read-csv (io/reader "resources/art.csv"))
  )
