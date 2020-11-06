(ns core
  (:require [hiccup.page :as page]
            [clojure.edn :as edn]))

(def artworks (edn/read-string (slurp "resources/art.edn")))
(def metadata {:domain "netart.today"})

(defn get-image-url [resource-url art]
  (str resource-url "img/" (:image art)))

(def header [:header.pl2 [:h1 [:a.link.dim.navy {:href (str "http://" (:domain metadata))} "Gallery 404"]]
             [:h2 "The net.art Gallery"]])

#_[:a {:rel "license" :href "http://creativecommons.org/licenses/by/4.0/"}
 [:img {:alt "Creative Commons License" :style "border-width:0" :src "https://i.creativecommons.org/l/by/4.0/80x15.png"}]]

(def footer [:footer.pv4.ph3.ph5-m.ph6-l.mid-gray
             [:small.f6.db.tc "This work is licensed under a " [:a {:rel "license" :href "http://creativecommons.org/licenses/by/4.0/"} "Creative Commons Attribution 4.0 International License"]]
             [:div.tc.mt3
              [:div [:i {:class "fab fa-mastodon" }] [:i {:class "fas fa-envelope"}]
               [:a.f6.dib.ph2.link.mid-gray.dim
                {:href "https://mastodon.social/@schmudde"} "Mastodon"]]]])

(defn head-template [resource-url]
  [:head
   [:title "net.art today"]
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "Content-Type" :content "text/html"}]
   [:link {:rel "icon" :href "/favicon.ico" :type "image/x-icon"}]
   [:link {:rel "stylesheet" :href (str resource-url "css/fontawesome/all.min.css")}]

   [:meta {:name "description" :content "The culture of a generation, lost to time."}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
   [:meta {:name "twitter:card" :content "summary_large_image"}]
   [:meta {:name "twitter:creator" :content "@dschmudde"}]
   [:meta {:property "og:url" :content (str "http://" (:domain metadata))}]
   [:meta {:property "og:title" :content "Gallery 404"}]
   [:meta {:property "og:author" :content "David Schmudde"}]
   [:meta {:property "og:image" :content (str "http://www." (:domain metadata) "/" (get-image-url resource-url (first artworks)))}]
   [:meta {:property "og:description" :content "The culture of a generation, lost to time."}]
   [:link {:rel "stylesheet" :href (str resource-url "css/tachyons.min.css")}]
   [:link {:rel "stylesheet" :href (str resource-url "css/netart.css")}]]

  ;; TODO: Add goat counter: https://www.goatcounter.com/
  )

(defn art->hiccup [resource-url art]
  (let [img-url (get-image-url resource-url art)
        current-archive (:current-archive art)]
    [:div
     [:h2.tc [:i (:title art)]
      [:small.normal (str "&nbsp;(" (:date art)  ") " )]]
     [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
      [:img {:alt (:title art) :title resource-url :src img-url :property "contentUrl"}]
      [:figcaption
       [:small.fr
        [:span {:property "license"}
         [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"} "CC"]]
        "&nbsp;"
        [:a {:href (:url art)}  "retrieved " (:retrieved art)]]
       [:i (:title art)] "&nbsp;"]
      [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]]
     [:div
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
               [:main.ph3.ph5-ns
                [:p [:a {:href "pages/1.html"} "next &rarr;"]]
                (art->hiccup "resources/" artwork)]
               #_footer
               [:script {:data-goatcounter "https://beyondtheframe.goatcounter.com/count"
                         :async true :src "//gc.zgo.at/count.js"} ]
               ]))

(defn make-art-page [artwork filename next-artwork]
  (spit (str "pages/" filename)
        (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
                    (head-template "../resources/")
                    [:body
                     header
                     [:main.ph3.ph5-ns
                      [:p (if next-artwork
                            [:a {:href next-artwork} "next &rarr;"]
                            [:a {:href "../index.html"} "home"])]
                      (art->hiccup "../resources/" artwork)]
                     #_footer
                     [:script {:data-goatcounter "https://beyondtheframe.goatcounter.com/count"
                               :async true :src "//gc.zgo.at/count.js"}]
                     ])))

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
