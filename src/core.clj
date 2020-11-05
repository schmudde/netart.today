(ns core
  (:require [hiccup.page :as page]
            [clojure.edn :as edn]))

(def artworks (edn/read-string (slurp "resources/art.edn")))
(def metadata {:domain "netart.today"})

(defn get-image-url [resource-url art]
  (str resource-url "img/" (:image art)))

(def header [:header.pl2 [:h1 [:a.link.dim.navy {:href (str "http://" (:domain metadata))} "Gallery 404"]]
             [:h2 "The net.art Gallery"]])

(defn head-template [resource-url]
  [:head
   [:title "net.art today"]
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "Content-Type" :content "text/html"}]
   [:link {:rel "icon" :href "/favicon.ico" :type "image/x-icon"}]

   [:meta {:name "description" :content "The culture of a generation, lost to time."}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
   [:meta {:name "twitter:card" :content "summary_large_image"}]
   [:meta {:name "twitter:creator" :content "@dschmudde"}]
   [:meta {:property "og:url" :content (str "http://" (:domain metadata))}]
   [:meta {:property "og:title" :content "Gallery 404"}]
   [:meta {:property "og:author" :content "David Schmudde"}]
   [:meta {:property "og:image" :content (str "http://www." (:domain metadata) "/" (get-image-url resource-url (first artworks)))}]
   [:meta {:property "og:description" :content "The culture of a generation, lost to time."}]
   [:link {:rel "stylesheet" :href "https://unpkg.com/tachyons@4.12.0/css/tachyons.min.css"}]
   [:link {:rel "stylesheet" :href (str resource-url "css/netart.css")}]]

  ;; TODO: Add goat counter: https://www.goatcounter.com/
  )

(defn art->hiccup [resource-url art]
  (let [img-url (get-image-url resource-url art)
        current-archive (:current-archive art)]
    [:div
     [:img {:alt (:title art) :src img-url}]
     [:div
      [:small.fr [:a {:href (:url art)}  "retrieved " (:retrieved art)]]
      [:p [:i (:title art)]
       (str "&nbsp;(" (:date art)  ") " )
       ]
      [:p [:stong (:artist art) "&nbsp;"]]
      [:blockquote.athelas.ml0.mt0.pl4.black-90.bl.bw2.b--blue (:desc art)
       [:cite.f6.ttu.tracked.fs-normal " ~ " [:a {:href (:desc-source art)} " source"]]]
      [:p "Original link via " [:a {:href (:link-from-url art)} (:link-from art)]
       (when current-archive
         [:span
          ", currently archived at "
          [:a {:href (:current-archive-url art)} current-archive]])]
      ]]))

(defn make-index-page [artwork]
  (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
              (head-template "resources/")
              [:body
               header
               [:main.pa3.pa5-ns
                [:p [:a {:href "pages/1.html"} "next &rarr;"]]
                (art->hiccup "resources/" artwork)]]))

(defn make-art-page [artwork filename next-artwork]
  (spit (str "pages/" filename)
        (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
                    (head-template "../resources/")
                    [:body
                     header
                     [:main.pa3.pa5-ns
                      [:p (if next-artwork
                            [:a {:href next-artwork} "next &rarr;"]
                            [:a {:href "../index.html"} "home"])]
                      (art->hiccup "../resources/" artwork)]])))

(defn make-pages [artworks]
  (loop [artworks artworks
         coll (range (count artworks)) ;; TODO: make a set
         cnt 0
         last-artwork "index.html"]
    (let [this-artwork (str cnt ".html")
          next-artwork (when (second coll) (str (second coll) ".html"))]
      (when-not (empty? artworks)
        (print "[" last-artwork " | " this-artwork " | " next-artwork "]")
        (make-art-page (first artworks) this-artwork next-artwork)
        (recur (rest artworks) (rest coll) (inc cnt) this-artwork)))))

(defn -main []
  (do
    (spit "index.html" (make-index-page (first artworks))) ;; TODO: make landing page
    (make-pages artworks)))
