(ns core
  (:require [about :as about]
            [gift-shop :as gift-shop]
            [news :as news]
            [utils :as u]
            [hiccup.page :as page]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [restoration-project :as restore]
            [windows-into-windows :as wiw]))

(def artworks (edn/read-string (slurp "resources/art.edn")))
(def site-url "https://www.broken.gallery/")
(def jodi "https://asdfg.jodi.org/-------------------------------/-------------------------------/-------------------------------/-------------------------------/-----------------------401qe663/vb663e.html")
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
  ([_ next-artwork]
   [:a.f3.b.no-underline.hover-dark-blue.blue {:href next-artwork} (str (next-link) (art-link) "] &rarr;")]))

(def header
  [:header.ph5-ns.ph3.pv2 [:h1.mb1 [:a.dim.no-underline.black {:href site-url} "Gallery 404"]]
   [:h2.f5.mv1 "The Museum of Broken net.art Art"]])

(def header-gift-shop
  [:header.ph5-ns.ph3.pv2 [:h1.mb1 [:a.dim.no-underline.black {:href site-url} "Gallery 404"]]
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
             [:div.tc {:vocab "http://schema.org/"}
              [:small
               [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"}
                [:i {:class "fab fa-creative-commons"}] "&nbsp;"
                [:i {:class "fab fa-creative-commons-by"}]]
               " "
               [:span {:property "copyrightHolder" :typeof "Person"} [:span {:property "name"} "David Schmudde"]]
               " "
               [:span {:property "copyrightYear"} (.getValue (java.time.Year/now))]]]
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

(defn absolute-url [path]
  (str site-url path))

(defn summarize
  "Plain-text excerpt for previews: strips HTML, keeps the first ~n characters at a word boundary."
  [text n]
  (let [plain (-> (str text)
                  (str/replace #"<[^>]+>" " ")
                  (str/replace #"&nbsp;" " ")
                  (str/replace #"&(ldquo|rdquo);" "\"")
                  (str/replace #"&(lsquo|rsquo);" "'")
                  (str/replace #"&amp;" "&")
                  (str/replace #"\s+" " ")
                  str/trim)]
    (if (<= (count plain) n)
      plain
      (str (str/replace (subs plain 0 n) #"\s+\S*$" "") "…"))))

(def default-og
  {:path ""
   :title "Gallery 404"
   :description "The culture of a generation, lost to time."
   :image (u/get-image-url "resources/" (first artworks))})

(defn artwork-og [art filename]
  (let [year (re-find #"\d{4}" (str (:date art)))
        artist (str/trim (str (:artist art)))]
    {:path (str "pages/" filename)
     :title (str (:title art)
                 (when (seq artist) (str " by " artist))
                 (when year (str " (" year ")")))
     :description (summarize (:desc art) 200)
     :image (u/get-image-url "resources/" art)}))

(defn head-template
  ([resource-url] (head-template resource-url {}))
  ([resource-url og]
  (let [{:keys [path title description image]} (merge default-og og)]
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
   [:meta {:property "og:site_name" :content "Gallery 404"}]
   [:meta {:property "og:url" :content (absolute-url path)}]
   [:meta {:property "og:title" :content title}]
   [:meta {:property "og:author" :content "David Schmudde"}]
   [:meta {:property "og:image" :content (absolute-url image)}]
   [:meta {:property "og:description" :content description}]
   [:link {:rel "stylesheet" :href (str resource-url "css/tachyons.min.css")}]
   [:link {:rel "stylesheet" :href (str resource-url "css/netart.css")}]])))

(defn art->hiccup [resource-url art]
  (let [img-url (u/get-image-url resource-url art)
        current-archive (:current-archive art)]
    [:div.cf.ph3.ph5-ns.pv3
     ;; image
     [:div.fn.fl-ns.w-60-l.pr4-l
      [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
       [:img {:alt (:title art) :title resource-url :src img-url :property "contentUrl"}]
       [:figcaption
        [:small.fr
         [:span
          [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"} [:i {:class "fab fa-creative-commons"}] "&nbsp;" [:i {:class "fab fa-creative-commons-by"}]]]
         "&nbsp;"
         [:a.link {:href (:url art)}  "retrieved " (:retrieved art)]]
        [:i (:title art)] "&nbsp;"]
       [:link {:property "acquireLicensePage" :href "https://schmud.de/pages/about.html"}]
       [:link {:property "about" :href (:url art)}]]]
     ;; info
     [:div.fn.fl-ns.w-40-l.pt3.pt0-l {:vocab "http://schema.org/" :about (:url art) :typeof "VisualArtwork"}
      [:link {:property "url" :href (:url art)}]
      [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2 {:property "name"} (:title art)]
      [:div
       [:p.f3.mid-gray.lh-title [:span {:property "creator"} (:artist art)] [:br ]
        (let [year (re-find #"\d{4}" (str (:date art)))]
          [:time.f6.ttu.tracked.gray (when year {:property "dateCreated" :datetime year :content year}) (:date art)])]
       [:blockquote.ml0.mt0.pl3.black-90.bl.bw2.b--blue [:div.mv3 {:property "description"} (:desc art)]
        [:cite.f6.ttu.tracked.fs-normal " ~ " [:a.link {:href (:desc-source art)} " source"]]]
       [:p "Original link via " [:a.link {:href (:link-from-url art)} (:link-from art)]
        (when current-archive
          [:span
           ", currently archived at "
           [:a.link {:href (:current-archive-url art) :property "archivedAt"} current-archive]])]]]
     ]))


(def chromium-license
  {:credit "The Chromium Authors" :license "BSD-3" :license-url "https://github.com/chromium/chromium/blob/main/LICENSE" :brand "fa-chrome"})

(def mozilla-license
  {:credit "Mozilla" :license "Fair use" :license-url "https://www-archive.mozilla.org/foundation/trademarks/faq" :brand "fa-firefox-browser"})

(def cited-icons
  [(merge chromium-license
          {:file "chrome-error_network_generic-trimmed.png" :alt "chrome can't find page icon"
           :source "https://github.com/chromium/chromium/blob/main/components/resources/default_200_percent/neterror/error_network_generic.png"
           :citation "The Chromium Authors, “error_network_generic.png” (200% scale), in Chromium Source Repository, GitHub, n.d. Accessed: Oct. 2026."})
   (merge mozilla-license
          {:file "mozilla-error-server-not-found-trimmed.svg" :alt "firefox can't find page icon"
           :source "https://bugzilla.mozilla.org/attachment.cgi?id=8861720"
           :citation "Mozilla, “mozilla-error-server-not-found.svg,” attachment to Bug 1358913, “[ux] error: server not found copy, design and illustration update,” Mozilla Bugzilla, 2017. Accessed: Oct. 2026."})
   (merge chromium-license
          {:file "chrome-favicon_sad_tab-trimmed.png" :alt "chrome crash icon"
           :source "https://github.com/chromium/chromium/blob/main/components/resources/default_300_percent/crash/favicon_sad_tab.png"
           :citation "The Chromium Authors, “favicon_sad_tab.png” (300% scale), in Chromium Source Repository, GitHub, n.d. Accessed: Oct. 2026."})
   (merge chromium-license
          {:file "chrome-200-error-offline-trimmed.png" :alt "chrome error offline icon"
           :source "https://github.com/chromium/chromium/blob/main/components/neterror/resources/images/default_200_percent/offline/200-error-offline.png"
           :citation "The Chromium Authors, “200-error-offline.png” (200% scale), in Chromium Source Repository, GitHub, n.d. Accessed: Oct. 2026."})])

(defn cited-icon [{:keys [file alt source citation credit license license-url]}]
  [:span {:vocab "http://schema.org/" :typeof "ImageObject"}
   [:a {:href source :title (str citation " License: " license ".") :target "_blank" :rel "noopener noreferrer" :property "isBasedOn"}
    [:img.ph2 {:src (str "resources/img/icons/cited/" file) :alt alt :class "icons" :property "contentUrl"}]]
   [:link {:href license-url :rel "license" :property "license"}]
   [:meta {:property "creditText" :content credit}]])

(defn make-index-page [artwork]
  (page/html5
   {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
   (head-template "resources/")
   [:body.sans-serif
    [:main.flex.flex-column.min-vh-100 {:vocab "http://schema.org/" :about site-url :typeof "WebSite"}
     [:link {:property "url" :href site-url}]
     [:span {:property "creator" :typeof "Person"} [:meta {:property "name" :content "David Schmudde"}]]
     [:h1.f-headline.lh-solid.mb0 {:property "name"} "Gallery 404"]
     [:h2.f3.ph3.lh-solid.mt1 {:property "alternativeHeadline"} "The Museum of Broken net.art Art"]
     [:section.flex-auto
      [:div.pa3 (dispatch-link :first-artwork)]
      [:div.pa3
       [:p.w-50-ns {:property "description"} "The culture of a generation, lost to time."]
       [:p.w-50-ns [:a.link.underline {:href "pages/about.html"} "About Gallery 404"] " and the preservation of digital artifacts."]
       [:br]
       [:div
        [:img.ph2 {:src (str "resources/img/icons/netscape.png") :alt "netscape missing image icon" :class "icons"}]
        [:img.ph2 {:src (str "resources/img/icons/netscape-plugin.gif") :alt "netscape missing plugin icon" :class "icons"}]
        (map cited-icon cited-icons)]]]
     [:footer
      [:p.ph3 {:vocab "http://schema.org/" :about "https://asdfg.jodi.org/" :typeof "VisualArtwork"}
       [:link {:property "url" :href "https://asdfg.jodi.org/"}]
       [:i {:class "fas fa-palette"}] " The flashing net.art is " [:em {:property "name"} "ASDFG.JODI.ORG"] " by " [:strong {:property "creator"} "JODI"] " (" [:span {:property "dateCreated"} "1998"] ")."]]
     [:div.h-100-ns.absolute-ns.top-0-ns.w-100 {:class "jodi"}
      [:iframe.h-100-ns.fr-ns {:src jodi :width 300 :title "JODI"}]]]

    analytics]))


(defn make-about-page []
  (page/html5
   {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
   (head-template "../resources/"
                  {:path "pages/about.html"
                   :title "About Gallery 404"
                   :description "Welcome to Gallery 404. We exclusively specialize in broken artworks. None of the works are for sale. You will find the exit just past the gift shop."
                   :image "resources/img/netartdiagram.gif"})
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
   (head-template "../resources/"
                  {:path "pages/gift-shop.html"
                   :title "The Gift Shop at Gallery 404"
                   :description "The Shop of Unbroken Digital Artifacts in the Commons."
                   :image "resources/gift-shop/img/gallery-404-poster.png"})
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

(defn make-recycling-page
  ([og f]
   (page/html5
    {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
    (head-template "../resources/" og)
    [:body.sans-serif
     [:main.flex.flex-column.min-vh-100 ;; .ph5-ns.ph3.pv2
      [:section.flex-auto.ph5-ns.ph3
       (f "../resources/")]]
     analytics]))
  ([og f path-to-artifact]
   (page/html5
    {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
    (head-template "../resources/" og)
    [:body.sans-serif
     [:main.flex.flex-column.min-vh-100 ;; .ph5-ns.ph3.pv2
      [:section.flex-auto.ph5-ns.ph3
       (f "../resources/" path-to-artifact)]]
     analytics])))

(defn make-recycling-pages []
  (let [no-of-artifacts 6] ;; currently building 6 versions of Light on the Net
  (doall (map #(let [destination (format "pages/restoration-project-final-%s.html" %1)
                     source (format "resources/img/restoration-project/%s/light-on-net.html" %1)]
                 (println destination) ;; build log
                 (spit destination (make-recycling-page
                                    {:path (str/replace destination #"^/" "")
                                     :title "The net.art Restoration Project: Restoration Complete!"
                                     :description "Light on the Net Project by Masaki Fujihata (1996)."
                                     :image (format "resources/img/restoration-project/%s.png" %1)}
                                    restore/final source)))
              (range 1 (inc no-of-artifacts) 1)))
  (spit "pages/restoration-project-artifacts.html"
        (make-recycling-page {:path "pages/restoration-project-artifacts.html"
                              :title "The net.art Restoration Project: Possible Objects"
                              :description (summarize "Our algorithms have created several options for a restored Light on the Net Project. Help train the LLM by selecting the best representation of this net.art classic." 200)
                              :image "resources/img/restoration-project/1.png"}
                             (partial restore/artifacts no-of-artifacts)))
  (spit "pages/restoration-project-recycling.html"
        (make-recycling-page {:path "pages/restoration-project-recycling.html"
                              :title "The net.art Restoration Project: Restore"
                              :description "LLMs have already looted our culture. In the absence of cultural governance, we have no choice but to relinquish the management of our digital artifacts to artificial intelligence."}
                             restore/restoring))
  (spit "pages/restoration-project-materials.html"
        (make-recycling-page {:path "pages/restoration-project-materials.html"
                              :title "The net.art Restoration Project: Materials"
                              :description "Here is a condensed inventory of the materials used to build Light on the Net Project. A Large Language Model (LLM) will use what it can to restore the artwork."}
                             restore/materials))
  (spit "pages/restoration-project.html"
        (make-recycling-page {:path "pages/restoration-project.html"
                              :title "The net.art Restoration Project"
                              :description "The world wide web is in decay. Much of what was created over its lifetime has disappeared from neglect or deliberate corporate purging."}
                             restore/intro))))


(defn make-windows-into-windows-page []
  (page/html5
      {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
      (head-template "../resources/"
                     {:path "pages/windows-into-windows.html"
                      :title "Windows Into Windows"
                      :description "“Windows Into Windows” is a set of modified public domain artworks from the last millennium that each depict the view from the artist's window."
                      :image "resources/wiw/img/overwrite-simulation-1.gif"})
      [:body.sans-serif
       [:main.flex.flex-column.min-vh-100 ;; .ph5-ns.ph3.pv2
        header-gift-shop
        [:nav.ph5-ns.ph3
         (dispatch-link :home) "&nbsp;&nbsp;"
         (dispatch-link :next-artwork "0.html")]
        [:section.flex-auto.ph5-ns.ph3
         (wiw/tech-sheet "../resources/")]
        footer]
       analytics]))

(defn make-news-page []
  (page/html5
      {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
      (head-template "../resources/"
                     {:path "pages/press-release.html"
                      :title "Gallery 404 Opens a Gift Shop Featuring a Unique Lineup of Artists and Scientists"
                      :description "Gallery 404, an online art gallery dealing exclusively in broken net.art artworks, has opened a gift shop spotlighting the significance of the digital commons."
                      :image "resources/gift-shop/img/gallery-404-poster.png"})
      [:body.sans-serif
       [:main.flex.flex-column.min-vh-100 ;; .ph5-ns.ph3.pv2
        header-gift-shop
        [:nav.ph5-ns.ph3
         (dispatch-link :home) "&nbsp;&nbsp;"
         (dispatch-link :next-artwork "0.html")]
        [:section.flex-auto.ph5-ns.ph3
         (news/press-release "../resources/")]
        footer]
       analytics]))

(defn make-art-page [artwork filename next-artwork]
  (let [nav (if next-artwork
              (dispatch-link :next-artwork next-artwork)
              (dispatch-link :home))]
    (spit (str "pages/" filename)
          (page/html5
           {:lang "en" :itemscope "itemscope" :itemtype "http://schema.org/WebPage"}
           (head-template "../resources/" (artwork-og artwork filename))
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
    (spit "pages/press-release.html" (make-news-page))
    (spit "pages/windows-into-windows.html" (make-windows-into-windows-page))
    (make-recycling-pages)
    (make-pages artworks)))
