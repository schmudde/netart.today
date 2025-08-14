(ns windows-into-windows)


(defn tech-sheet [resource-url]
  (let [tech-sheet (slurp "resources/wiw/wiw-tech-sheet.html")]
    [:article
     [:div.pb3 {:itemscope "itemscope", :itemtype "http://schema.org/BlogPosting"}
      [:meta {:content "David Schmudde", :itemprop "author"}]
      [:h1.f3.f1-m.f-headline-l "Windows Into Windows"]
      [:img {:alt "under construction" :title "under construction" :src (str resource-url "wiw/img/under-construction.gif") :property "contentUrl"}]
      [:h2.f5.f4-m.f3-l "Exhibition Site: WÔL Communicative Façade, Via Tarino 14, Torino"]
      [:p.measure.lh-copy.tj "&ldquo;Windows Into Windows&rdquo; is a set of modified public domain artworks from the last millennium that each depict the view from the artist's window. These images will be bordered by a web browser window - a mediated view into our current technologically-mediated world."]
      [:p.measure.lh-copy.tj "All images used for this project will be in the public domain. The outside world is our shared space. The images are our shared culture. The free sharing of our culture through media is of paramount importance."]
      [:div.cf.ph3.ph5-ns.pv3
       [:div.fn.fl-ns.w-50-l.pr5-l [:div tech-sheet]]
       [:div.fn.fl-ns.w-50-l.pt3.pt0-l
        [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
         [:img {:alt "Early Mockup" :title "Early Mockup" :src (str resource-url "img/wiw/overwrite-simulation-1.gif") :property "contentUrl"}]
         [:figcaption
          [:small
           [:i "Early Mockup of &ldquo;Windows Into Windows&rdquo;"] "&nbsp;&nbsp;"
           [:span {:property "license"}
            [:a.link {:href "https://creativecommons.org/licenses/by/4.0/" :rel "license"} [:i {:class "fab fa-creative-commons"}] "&nbsp;" [:i {:class "fab fa-creative-commons-by"}]]]]]
         [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]]]]]]))
