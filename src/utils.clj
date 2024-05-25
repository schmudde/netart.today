(ns utils)

(defn get-image-url [resource-url art]
  {:pre [(coll? art)]}
  (str resource-url "img/" (:image art)))
