(ns core
  (:require [hiccup.page :as page]
            [clojure.edn :as edn]
            [meta-csv.core :as csv]))

(def artworks (edn/read-string (slurp "resources/art.edn")))

(defn head-template []
  [:head
   [:title "net.art today"]
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "Content-Type" :content "text/html"}]
   [:link {:rel "icon" :href "/favicon.ico" :type "image/x-icon"}]
   #_[:link {:rel "stylesheet" :href "/css/fontawesome/all.min.css"}]

   [:meta {:name "description" :content "TODO"}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
   [:meta {:name "twitter:card" :content "summary_large_image"}]
   [:meta {:name "twitter:creator" :content "@dschmudde"}]
   [:meta {:property "og:url" :content "http://www.netart.today/"}]
   [:meta {:property "og:title" :content "net.art today"}]
   [:meta {:property "og:author" :content "David Schmudde"}]
   [:meta {:property "og:image" :content "TODO"}]
   [:meta {:property "og:description" :content "TODO"}]
   [:link {:rel "stylesheet" :href "resources/css/netart.css"}]])

(defn art->hiccup [art]
  (let [img-url (str "resources/img/" (:image art))]
    [:div
     [:img {:alt (:title art) :src img-url}]
     [:p (:title art)]]))

(defn -main []
  (print (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
               (head-template)
               [:body
                [:header [:h1 "net.art today"]
                 [:h2 "Revisiting net.art sites in 2020"]]
                [:main
                 (art->hiccup (first artworks))]])))
