(ns core
  (:require [hiccup.page :as page]
            [clojure.edn :as edn]))

(def artworks (edn/read-string (slurp "resources/art.edn")))
(def metadata {:domain "netart.today"})
(def jodi "http://asdfg.jodi.org/-------------------------------/-------------------------------/-------------------------------/-------------------------------/-----------------------401qe663/vb663e.html")

(defn get-image-url [resource-url art]
  (str resource-url "img/" (:image art)))

(def header
  [:header.ph5-ns.ph3.pv2 [:h1 [:a.link.dim.navy {:href (str "http://" (:domain metadata))} "Gallery 404"]]
   [:h2 "The net.art Gallery"]])

#_[:a {:rel "license" :href "http://creativecommons.org/licenses/by/4.0/"}
 [:img {:alt "Creative Commons License" :style "border-width:0" :src "https://i.creativecommons.org/l/by/4.0/80x15.png"}]]

(def footer [:footer.pv4.ph3.ph5-m.ph6-l.mid-gray
             [:small.f6.db.tc "This work is licensed under a " [:a {:rel "license" :href "http://creativecommons.org/licenses/by/4.0/"} "Creative Commons Attribution 4.0 International License"]]
             [:div.tc.mt3
              [:div
               [:i {:class "fab fa-mastodon" }] [:i {:class "fas fa-envelope"}]
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
   [:link {:rel "stylesheet" :href (str resource-url "css/netart.css")}]])

(defn art->hiccup [resource-url art]
  (let [img-url (get-image-url resource-url art)
        current-archive (:current-archive art)]
    [:article.cf.ph3.ph5-ns.pv3
     ;; image
     [:div.fn.fl-ns.w-60-l.pr4-l
      [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
       [:img {:alt (:title art) :title resource-url :src img-url :property "contentUrl"}]
       [:figcaption
        [:small.fr
         [:span {:property "license"}
          [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"} [:i {:class "fab fa-creative-commons"}]]]
         "&nbsp;"
         [:a {:href (:url art)}  "retrieved " (:retrieved art)]]
        [:i (:title art)] "&nbsp;"]
       [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]]]
     ;; info
     [:div.fn.fl-ns.w-40-l.pt3.pt0-l
      [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  (:title art)]
      [:div
       [:p.f3.mid-gray.lh-title (:artist art) [:br ]
        [:time.f6.ttu.tracked.gray (:date art) ]]
       [:blockquote.ml0.mt0.pl3.black-90.bl.bw2.b--blue (:desc art)
        [:cite.f6.ttu.tracked.fs-normal " ~ " [:a {:href (:desc-source art)} " source"]]]
       [:p "Original link via " [:a {:href (:link-from-url art)} (:link-from art)]
        (when current-archive
          [:span
           ", currently archived at "
           [:a {:href (:current-archive-url art)} current-archive]])]]]
     ]))

(defn make-index-page [artwork]
  (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
              (head-template "resources/")
              [:body.sans-serif
               [:main
                [:h1.f-headline.lh-solid "Gallery 404"]
                [:h1.f-subheadline.lh-solid "The net.art Gallery"]
                [:div.pa3 [:a.f3.b.link.underline-hover.hover-blue.red {:href "pages/0.html"} "Enter &rarr;"]]
                [:div.pa3.tj [:p.w-50 "The culture of a generation, lost to time."]
                 [:img.ph2 {:src (str "resources/img/icons/netscape.png") :alt "netscape missing image icon" :class "icons"}]
                 [:img.ph2 {:src (str "resources/img/icons/netscape-plugin.gif") :alt "netscape missing plugin icon" :class "icons"}]
                 [:img.ph2 {:src (str "resources/img/icons/chrome.png") :alt "chrome can't find page icon" :class "icons"}]
                 [:img.ph2 {:src (str "resources/img/icons/firefox.png") :alt "firefox can't find page icon" :class "icons"}]
                 [:img.ph2 {:src (str "resources/img/icons/chrome-error-code.png") :alt "chrome crash icon" :class "icons"}]
                 [:img.ph2 {:src (str "resources/img/icons/plugin-1.png") :alt "chrome missing plugin icon" :class "icons"}]]
                [:div.h-100-ns.absolute-ns.top-0-ns.w-100 {:class "jodi"}
                 [:iframe.h-100-ns.fr-ns {:src jodi :width 300 :title "JODI"}]]]
               #_footer
               [:script {:data-goatcounter "https://beyondtheframe.goatcounter.com/count"
                         :async true :src "//gc.zgo.at/count.js"} ]
               ]))


(defn make-art-page [artwork filename next-artwork]
  (let [nav (if next-artwork
              [:a.f3.b.link.underline-hover.hover-blue.red {:href next-artwork} "next &rarr;"]
              [:a.f3.b.link.underline-hover.hover-blue.red {:href "../index.html"} "home"])]
    (spit (str "pages/" filename)
          (page/html5 {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
                      (head-template "../resources/")
                      [:body.sans-serif
                       header
                       [:main
                        [:div.ph5-ns.ph3 nav]
                        (art->hiccup "../resources/" artwork)]
                       #_footer
                       [:script {:data-goatcounter "https://beyondtheframe.goatcounter.com/count"
                                 :async true :src "//gc.zgo.at/count.js"}]
                       ]))))

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

(-main)
