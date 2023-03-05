(ns gift-shop
  (:require [clojure.string :refer [lower-case]]
            [clojure.java.io :as io]))

(def shop-items
  {:fix-my-code
   {:item-name "Fix My Code"
    :attribution "Cornelia Sollfrank, Winnie Soon"
    :medium ["Book"]
    :description "<blockquote>1999 marked the third version of Cornelia Sollfrank’s &ldquo;Net Art Generator&rdquo; (NAG). This particular work is the focus of a new book by Cornelia Sollfrank and Winnie Soon titled &ldquo;Fix My Code.&rdquo; The artist (Sollfrank) and the creative technologist and coder (Soon) confront issues of authenticity and ownership through a series of insightful conversations as they update the NAG’s code for the 21st century.</blockquote>~ <a href=\"https://schmud.de/posts/2021-09-07-fix-my-code.html\">Beyond the Frame</a>"
    :resource-url "https://eeclectic.de/produkt/fix-my-code/"
    :img-url "gift-shop/img/fix-my-code.jpg"
    :img-alt "&ldquo;Fix My Code&rdquo; Cover"
    :download "gift-shop/assets/fix-my-code-sollfrank-2021.zip"
    :dontate "https://www.paypal.com/donate?token=GUJfgzN5Z-NJauMnPFngJDC48u_IHxdTXYrblUvWSk5fFgwo-NqqNTWS7kH_uwaZ6muY40fQRFKDTb1G"
    :license "Creative Commons: Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)"
    :license-url "https://creativecommons.org/licenses/by-sa/4.0/"}
   :first-online-sentence
   {:item-name "Not Making the World's First Collaborative Sentence"
    :attribution "D. Schmudde"
    :medium ["Software" "NFT"]
    :description "<p>Launched in 1994. Broken by 2012. <a href=\"https://whitney.org/artport/douglas-davis\">Restored in 2013</a>. Broken by 2021.</p><p>&ldquo;Not Making the World's First Collaborative Sentence&rdquo; is an original artwork which emodies the current state of many net.art artworks. The interactive component returns the same error message as Douglas Davis' seminal work, &ldquo;The World's First Collaborative Sentence&rdquo; (1994). Davis' work was <a href=\"https://artport.whitney.org/collection/DouglasDavis/live/writesentence.html\">restored by the Whitney Museum in 2013</a> but no longer functions as of 2022.</p>

<p>Its current state of brokeness has been recorded to the Tezos blockchain <a href=\"https://objkt.com/asset/hicetnunc/605464\">where the open source artwork can be owned for a nominal cost.</a></p>"
    :download "gift-shop/assets/not-the-worlds-first-collaborative-sentence.zip"
    :resource-url "https://hicetnunc.art/objkt/605464"
    :img-url "gift-shop/img/not-making-worlds-first-collaborative-sentence.png"
    :img-alt "&ldquo;Not Making the World's First Collaborative Sentence&rdquo; Thumbnail"
    :license "MIT License"
    :license-url "../research/art/not-the-worlds-first-collaborative-sentence/license.txt"}
   :the-slip
   {:item-name "The Slip"
    :attribution "Nine Inch Nails"
    :medium ["Audio"]
    :description "<blockquote>&ldquo;The Slip&rdquo; is the seventh studio album by American industrial rock act Nine Inch Nails, released on May 5, 2008 via digital download. Described by Reznor as &ldquo;Garage Electronics,&rdquo; &ldquo;The Slip&rdquo; was the result of an inspired three weeks following the completion of Ghosts I-IV.  An experiment in working with a compressed timeline, the results make for a noisy, sloppy and exciting listen with several songs that have been live staples.</blockquote>~ Nine Inch Nails, <a href=\"https://www.nin.com/music/the-slip/\">Official Website</a>/<a href=\"https://www.nin.wiki/The_Slip\">Wiki</a>"
    :download "gift-shop/assets/the-slip.zip"
    :resource-url "https://www.nin.wiki/The_Slip"
    :img-url "gift-shop/img/the-slip.jpg"
    :img-alt "&ldquo;The Slip&rdquo; Cover"
    :license "Attribution-NonCommercial-ShareAlike 3.0 United States (CC BY-NC-SA 3.0 US)"
    :license-url "https://creativecommons.org/licenses/by-nc-sa/3.0/us/"}
   :apollo-11
   {:item-name "Apollo 11 Guidance Computer Source Code"
    :attribution "NASA, Ron Burkey, et al."
    :medium ["Software"]
    :description "Original Apollo 11 guidance computer (AGC) <a href=\"https://github.com/chrislgarry/Apollo-11\">source code</a> for Command Module (Comanche055) and Lunar Module (Luminary099).<blockquote>Former NASA intern Chris Garry has posted the entire Apollo Guidance Computer source code on GitHub, giving you a good peek at the software that took NASA to the Moon. As Reddit users point out, it's clear that the developers had a mighty sense of humor -- line 666 of the lunar landing turns up a &ldquo;numero mysterioso,&rdquo; and there's even a reference to radio DJ Magnificent Montague's classic &ldquo;burn, baby, burn.&rdquo;</blockquote> ~ <a href=\"https://www.engadget.com/2016-07-10-apollo-11-source-code-on-github.html\">Jon Fingas</a> (2016)<p>The code can be run in an <a href=\"http://ibiblio.org/apollo/index.html\">emulation project</a> spearheaded by Ron Burkey.</p>"
    :resource-url "http://ibiblio.org/apollo/index.html"
    :img-url "gift-shop/img/apollo-f-8.jpg"
    :img-alt "Apollo display and keyboard unit. Photo by NASA/Dennis Taylor."
    :license "CC0"
    :license-url "https://creativecommons.org/publicdomain/zero/1.0/"
    :img-license "Public Domain"
    :img-license-url "https://www.dfrc.nasa.gov/Gallery/Photo/F-8DFBW/HTML/EC96-43408-1.html"}
   :maintainers
   {:item-name "The Maintainers Coloring Book"
    :attribution "The Maintainers Team"
    :year 2023
    :medium ["Book"]
    :description "<blockquote>Not unlike many facets of life, The Maintainers Coloring Book project required re-orientation since Covid-19 began to alter the world in 2020. The concepts of maintenance explored through these pages reflect a unique moment, prior to that reality.  Many aspects of our collective relationship to maintenance have changed, while others have become more apparent. Throughout this coloring book we wish to bring reflective questions, guiding you to identify your connection to maintenance and how it changes over time.  </blockquote>~ <a href=\"https://themaintainers.org/the-maintainers-coloring-book/\">The Maintainers Team</a>"
    :resource-url "https://themaintainers.org/the-maintainers-coloring-book/"
    :img-url "gift-shop/img/maintainers.png"
    :img-alt "&ldquo;The Maintainers Coloring Book&rdquo; Cover"
    :download "gift-shop/assets/the-maintainers-coloring-book.pdf"
    :license "Creative Commons: Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)"
    :license-url "https://creativecommons.org/licenses/by-sa/4.0/"}
   :know-justice-know-peace
   {:item-name "Know Justice Know Peace"
    :attribution "Amos Kennedy"
    :year 2020
    :medium ["Poster"]
    :description "<blockquote>Amos Paul Kennedy Jr. is an American printer, book artist and papermaker best known for social and political commentary, particularly in printed posters. Kennedy articulated his fascination with letterpress printing in one interview: &ldquo;...I
believe it was the capability of making multiples. Multiples of text are important to me.
They allow for distribution.&rdquo;</blockquote>~ <a href=\"https://en.wikipedia.org/wiki/Amos_Paul_Kennedy_Jr.\">Wikipedia</a>"
    :resource-url "https://www.metmuseum.org/art/collection/search/852939"
    :img-url "gift-shop/img/know-justice-know-peace.jpg"
    :img-alt "&ldquo;Know Justice Know Peace&rdquo; Letterpress Poster"
    :download "gift-shop/img/know-justice-know-peace.jpg"
    :license "Creative Commons Zero (CC0)"
    :license-url "https://www.metmuseum.org/about-the-met/policies-and-documents/open-access"}
   })


(defn make-shop-image [root {item-name :item-name resource-url :resource-url img-url :img-url img-alt :img-alt}]
  [:figure.dib {:vocab "http://schema.org/" :typeof "ImageObject"}
   [:a {:href resource-url}
    [:img {:alt img-alt :title img-alt :src (str root img-url) :property "contentUrl"}]]
   [:figcaption
    [:i img-alt] "&nbsp;"]
   [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]])

(defn make-tags [tags]
  (->
   (mapv #(str "#" (lower-case %) ", ") (butlast tags))
   (conj (str "#" (lower-case (last tags))))))

(defn make-shop-info [root {item-name :item-name attr :attribution medium :medium desc :description download :download license :license license-url :license-url}]
  [:span
   [:h3 item-name]
   [:p "by " [:strong attr]]
   [:small [:i {:class "fa fa-tags"}] "&nbsp;" (reduce str (make-tags medium))]
   [:p desc]
   (when download
     [:p [:i {:class "fa fa-download"}] "&nbsp;" [:a {:href (str root download)} "download"]])
   [:small [:i {:class "fas fa-balance-scale"}] "&nbsp;" [:a {:href license-url} license]]])

(defn gift-shop [root]
  (let [shop-item-layout :div.w-25-ns.w-50-m.w-100.pa3]
    [:div {:itemscope "itemscope", :itemtype "http://schema.org/BlogPosting"}
     [:meta {:content "David Schmudde", :itemprop "author"}]
     [:h3 "Welcome to the Gift Shop"]
     [:p "Gallery 404 is making a statement about digital objects and their value. It clearly states that we are not taking the preservation of digital culture seriously enough. A more subtle observation is that digital culture that is not free (as in libre, not as in beer) decays faster. The most prominent example are creative works done in non-free technologies like Flash. Gallery 404 exhibits many of these. The shop should re-enforce these concepts so Gallery 404 can be a complete artwork. I can also see room for inexpensive/free digital objects. Perhaps a self-erasing software notebook?"]
     [:div.flex.flex-wrap
      [shop-item-layout
       (make-shop-image root (:fix-my-code shop-items))]
      [shop-item-layout
       (make-shop-info root (:fix-my-code shop-items))]
      [shop-item-layout
       (make-shop-image root (:first-online-sentence shop-items))]
      [shop-item-layout
       (make-shop-info root (:first-online-sentence shop-items))]
      [shop-item-layout
       (make-shop-image root (:the-slip shop-items))]
      [shop-item-layout
       (make-shop-info root (:the-slip shop-items))]
      [shop-item-layout
       (make-shop-image root (:apollo-11 shop-items))]
      [shop-item-layout
       (make-shop-info root (:apollo-11 shop-items))]
      [shop-item-layout
       (make-shop-image root (:maintainers shop-items))]
      [shop-item-layout
       (make-shop-info root (:maintainers shop-items))]
      [shop-item-layout
       (make-shop-image root (:know-justice-know-peace shop-items))]
      [shop-item-layout
       (make-shop-info root (:know-justice-know-peace shop-items))]

      ]
     ])
  )
