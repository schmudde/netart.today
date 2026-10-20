(ns utils
  (:require [clojure.string :as str]))

(defn get-image-url [resource-url art]
  {:pre [(coll? art)]}
  (str resource-url "img/" (str/replace (:image art) " " "%20")))
