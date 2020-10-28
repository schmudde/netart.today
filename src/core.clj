(ns core
  (:require [hiccup.page :as page]))

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
   [:link {:rel "stylesheet" :href "/css/tachyons.min.css"}]

   ])

(defn -main []
  (print (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
               (head-template)
               [:body
                [:header [:h1 "net.art today"]]
                [:img {:title "net.art" :src "resources/img/gallery9-walker-20201005155928-1922x1055.png"}]])))
