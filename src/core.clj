(ns core
  (:require [about :as about]
            [gift-shop :as gift-shop]
            [hiccup.page :as page]
            [clojure.edn :as edn]))

(def artworks (edn/read-string (slurp "resources/art.edn")))
(def metadata {:domain "netart.today"})
(def jodi "http://asdfg.jodi.org/-------------------------------/-------------------------------/-------------------------------/-------------------------------/-----------------------401qe663/vb663e.html")
(def analytics [:script {:data-goatcounter "https://gallery404.goatcounter.com/count"
                         :async true :src "//gc.zgo.at/count.js"}])

(def next-link
  (fn []
    (let [next ["[ne̶x̴t̶." "[next." "[ń̶e̶͐x̷͉̆t̶." "[nex̷̆t." "[next." "[next." "[n̴e̴x̸t." "[̸ne̴x̸t̵." "[next." "[next." "[next." "[next."]]
      (get next (rand-int (count next))))))

(def art-link
  (fn []
    (let [art ["art" "a̸r̷t" "a̷rt̸" "ar̷t" "a̷rt̸" "a̴r̴t̸" "a̴rt̸" "á̵̘r̸͉̚t" "á̵̘rẗ̶" "art̶" "a̵r̴͐t̵" "a̵̞͗́rt̵"]]
      (get art (rand-int (count art))))))

(defn dispatch-link
  ([link]
   (case link
     :home [:a.f3.b.no-underline.hover-dark-blue.blue {:href "../index.html"} "[home]"]
     :first-artwork [:a.f1.b.no-underline.hover-dark-blue.blue {:href "pages/0.html"} "Enter &rarr;"]
     :about [:a.f3.b.no-underline.hover-dark-blue.blue {:href "about.html"} "[about]"]
     :gift-shop [:a.f3.b.no-underline.hover-dark-blue.blue {:href "gift-shop.html"} "[gift shop]"]))
  ([link next-artwork]
   [:a.f3.b.no-underline.hover-dark-blue.blue {:href next-artwork} (str (next-link) (art-link) "] &rarr;")]))

(defn get-image-url [resource-url art]
  (str resource-url "img/" (:image art)))

(def header
  [:header.ph5-ns.ph3.pv2 [:h1.mb1 [:a.dim.no-underline.black {:href (str "http://" (:domain metadata))} "Gallery 404"]]
   [:h2.f5.mv1 "The Museum of Broken net.art Art"]])

(def header-gift-shop
  [:header.ph5-ns.ph3.pv2 [:h1.mb1 [:a.dim.no-underline.black {:href (str "http://" (:domain metadata))} "Gallery 404"]]
   [:h2.f5.mv1 "The Museum of Broken net.art Art"]])

(def footer [:footer.pv4.ph3.ph5-m.ph6-l.mid-gray
             [:hr ]
             [:div.tc.mb3
              [:div
               [:a.f5.dib.ph2.link.dim
                {:href "../index.html"} "Home"]
               [:a.f5.dib.ph2.link.dim
                {:href "0.html"} "Gallery"]
               [:a.f5.dib.ph2.link.dim
                {:href "about.html"} "About"]
               [:a.f5.dib.ph2.link.dim
                {:href "gift-shop.html"} "Gift Shop"]]]
             [:div.tc {:property "license"}
              [:small
               [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"}
                [:i {:class "fab fa-creative-commons"}] "&nbsp;"
                [:i {:class "fab fa-creative-commons-by"}]]
               [:span " David Schmudde 2023"]]]
             [:div.tc.mt3
              [:div
               [:a.f5.dib.ph2.link.dim
                {:href "https://twitter.com/dschmudde"}
                [:i {:class "fab fa-twitter" }]]
               [:a.f5.dib.ph2.link.dim
                {:href "https://mastodon.social/@schmudde"}
                [:i {:class "fab fa-mastodon"}]]
               [:a.f5.dib.ph2.link.dim
                {:href "mailto:d@schmud.de"}
                [:i {:class "fas fa-envelope"}]]]]])

(defn head-template [resource-url]
  [:head
   [:title "Gallery 404"]
   [:meta {:charset "utf-8"}]
   [:meta {:http-equiv "Content-Type" :content "text/html"}]
   [:link {:rel "icon" :href "/favicon.ico" :type "image/x-icon"}]
   [:link {:rel "stylesheet" :href (str resource-url "css/fontawesome/all.min.css")}]

   [:meta {:name "description" :content "The culture of a generation, lost to time."}]
   [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
   [:meta {:name "keywords" :content "netart rhizome Monoskop"}]
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
    [:div.cf.ph3.ph5-ns.pv3
     ;; image
     [:div.fn.fl-ns.w-60-l.pr4-l
      [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
       [:img {:alt (:title art) :title resource-url :src img-url :property "contentUrl"}]
       [:figcaption
        [:small.fr
         [:span {:property "license"}
          [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"} [:i {:class "fab fa-creative-commons"}] "&nbsp;" [:i {:class "fab fa-creative-commons-by"}]]]
         "&nbsp;"
         [:a.link {:href (:url art)}  "retrieved " (:retrieved art)]]
        [:i (:title art)] "&nbsp;"]
       [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]]]
     ;; info
     [:div.fn.fl-ns.w-40-l.pt3.pt0-l
      [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  (:title art)]
      [:div
       [:p.f3.mid-gray.lh-title (:artist art) [:br ]
        [:time.f6.ttu.tracked.gray (:date art) ]]
       [:blockquote.ml0.mt0.pl3.black-90.bl.bw2.b--blue [:p (:desc art)]
        [:cite.f6.ttu.tracked.fs-normal " ~ " [:a.link {:href (:desc-source art)} " source"]]]
       [:p "Original link via " [:a.link {:href (:link-from-url art)} (:link-from art)]
        (when current-archive
          [:span
           ", currently archived at "
           [:a.link {:href (:current-archive-url art)} current-archive]])]]]
     ]))


(defn make-index-page [artwork]
  (page/html5
   {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
   (head-template "resources/")
   [:body.sans-serif
    [:main.flex.flex-column.min-vh-100
     [:h1.f-headline.lh-solid.mb0 "Gallery 404"]
     [:h2.f3.ph3.lh-solid.mt1 "The Museum of Broken net.art Art"]
     [:section.flex-auto
      [:div.pa3 (dispatch-link :first-artwork)]
      [:div.pa3
       [:p.w-50-ns "The culture of a generation, lost to time."]
       [:p.w-50-ns [:a.link.underline {:href "pages/about.html"} "About Gallery 404"] " and the preservation of digital artifacts."]
       [:br]
       [:div
        [:img.ph2 {:src (str "resources/img/icons/netscape.png") :alt "netscape missing image icon" :class "icons"}]
        [:img.ph2 {:src (str "resources/img/icons/netscape-plugin.gif") :alt "netscape missing plugin icon" :class "icons"}]
        [:img.ph2 {:src (str "resources/img/icons/chrome.png") :alt "chrome can't find page icon" :class "icons"}]
        [:img.ph2 {:src (str "resources/img/icons/firefox.png") :alt "firefox can't find page icon" :class "icons"}]
        [:img.ph2 {:src (str "resources/img/icons/chrome-error-code.png") :alt "chrome crash icon" :class "icons"}]
        [:img.ph2 {:src (str "resources/img/icons/plugin-1.png") :alt "chrome missing plugin icon" :class "icons"}]]]]
     [:footer
      [:p.ph3 [:i {:class "fas fa-palette"}] " The flashing net.art is " [:em "ASDFG.JODI.ORG"] " by " [:strong "JODI"] " (1998)."]]
     [:div.h-100-ns.absolute-ns.top-0-ns.w-100 {:class "jodi"}
      [:iframe.h-100-ns.fr-ns {:src jodi :width 300 :title "JODI"}]]]

    analytics]))


(defn make-about-page []
  (page/html5
   {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
   (head-template "../resources/")
   [:body.sans-serif
    [:main.flex.flex-column.min-vh-100 ;; .ph5-ns.ph3.pv2
     header
     [:nav.ph5-ns.ph3
      (dispatch-link :home) "&nbsp;&nbsp;"
      (dispatch-link :gift-shop) "&nbsp;&nbsp;"
      (dispatch-link :next-artwork "0.html")]
     [:section.flex-auto.ph5-ns.ph3
      (about/about-article "../resources/")]
    footer]
    analytics]))

(defn make-gift-shop-page []
  (page/html5
   {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
   (head-template "../resources/")
   [:body.sans-serif
    [:main.flex.flex-column.min-vh-100 ;; .ph5-ns.ph3.pv2
     header-gift-shop
     [:nav.ph5-ns.ph3
      (dispatch-link :home) "&nbsp;&nbsp;"
      (dispatch-link :next-artwork "0.html")]
     [:section.flex-auto.ph5-ns.ph3
      (gift-shop/gift-shop "../resources/")]
     footer]
    analytics]))

(defn make-art-page [artwork filename next-artwork]
  (let [nav (if next-artwork
              (dispatch-link :next-artwork next-artwork)
              (dispatch-link :home))]
    (spit (str "pages/" filename)
          (page/html5
           {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
           (head-template "../resources/")
           [:body.sans-serif
            [:main.flex.flex-column.min-vh-100
             header
             [:nav.ph5-ns.ph3
              (dispatch-link :about) "&nbsp;&nbsp;"
              (dispatch-link :gift-shop) "&nbsp;&nbsp;"
              nav]
             [:section.flex-auto
              (art->hiccup "../resources/" artwork)]
             footer] analytics]))))

(defn make-pages [artworks]
  (loop [artworks artworks
         coll (range (count artworks)) ;; TODO: make a set
         cnt 0
         last-artwork "index.html"]
    (let [this-artwork (str cnt ".html")
          next-artwork (when (second coll) (str (second coll) ".html"))]
      (when-not (empty? artworks)
        (println "[" last-artwork " | " this-artwork " | " next-artwork "]")
        (make-art-page (first artworks) this-artwork next-artwork )
        (recur (rest artworks) (rest coll) (inc cnt) this-artwork)))))

(defn -main []
  (do
    (spit "index.html" (make-index-page (first artworks)))
    (spit "pages/about.html" (make-about-page))
    (spit "pages/gift-shop.html" (make-gift-shop-page))
    (make-pages artworks)))
