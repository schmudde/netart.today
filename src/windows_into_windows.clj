(ns windows-into-windows)


(defn tech-sheet [root]
  (let [tech-sheet (slurp "resources/wiw/wiw-tech-sheet.html")]
    [:article
     [:div.pb3
      [:h1.f3.f1-m.f-headline-l "Windows Into Windows"]
      [:img {:alt "under construction" :title "under construction" :src (str root "wiw/img/under-construction.gif") :property "contentUrl"}]
      [:h2.f5.f4-m.f3-l "Exhibition Site: WÔL Communicative Façade, Via Tarino 14, Torino"]
      [:p.measure.lh-copy.tj "&ldquo;Windows Into Windows&rdquo; is a set of modified public domain artworks from the last millennium that each depict the view from the artist's window. These images will be bordered by a web browser window - a mediated view into our current technologically-mediated world."]
      [:p.measure.lh-copy.tj "All images used for this project will be in the public domain. The outside world is our shared space. The images are our shared culture. The free sharing of our culture through media is of paramount importance."]]
     [:div {:itemscope "itemscope", :itemtype "http://schema.org/BlogPosting"}
      [:meta {:content "David Schmudde", :itemprop "author"}]
      [:div [:center tech-sheet]]]]))
