(ns gift-shop)


(def shop-items
  {:fix-my-code
   {:item-name "Fix My Code"
    :attribution "Cornelia Sollfrank, Winnie Soon"
    :medium "Book"
    :description "<blockquote>1999 marked the third version of Cornelia Sollfrank’s &ldquo;Net Art Generator&rdquo; (NAG). This particular work is the focus of a new book by Cornelia Sollfrank and Winnie Soon titled &ldquo;Fix My Code.&rdquo; The artist (Sollfrank) and the creative technologist and coder (Soon) confront issues of authenticity and ownership through a series of insightful conversations as they update the NAG’s code for the 21st century.</blockquote>~<a href=&ldquo;https://schmud.de/posts/2021-09-07-fix-my-code.html&rdquo;>Beyond the Frame</a>"
    :resource-url "https://eeclectic.de/produkt/fix-my-code/"
    :img-url "img/gift-shop/fix-my-code.jpg"
    :img-alt "&ldquo;Fix My Code&rdquo; Cover"
    :download ""
    :dontate "https://www.paypal.com/donate?token=GUJfgzN5Z-NJauMnPFngJDC48u_IHxdTXYrblUvWSk5fFgwo-NqqNTWS7kH_uwaZ6muY40fQRFKDTb1G"
    :license "Creative Commons: Attribution-ShareAlike 4.0 International (CC BY-SA 4.0)"
    :license-url "https://creativecommons.org/licenses/by-sa/4.0/"    }
   :first-online-sentence
   {:item-name "Not Making the World's First Collaborative Sentence"
    :attribution "D. Schmudde"
    :medium "Software/NFT"
    :description "<p>Launched in 1994. Broken by 2012. <a href=\"https://whitney.org/artport/douglas-davis\">Restored in 2013</a>. Broken by 2021.</p><p>&ldquo;Not Making the World's First Collaborative Sentence&rdquo; is an original artwork which emodies the current state of many net.art artworks. The interactive component returns the same error message as Douglas Davis' seminal work, &ldquo;The World's First Collaborative Sentence&rdquo; (1994). Davis' work was <a href=\"https://artport.whitney.org/collection/DouglasDavis/live/writesentence.html\">restored by the Whitney Museum in 2013</a> but no longer functions as of 2022.</p><p>&ldquo;Not Making the World's First Collaborative Sentence&rdquo; is available as an open license artwork. Although it is &ldquo;broken,&rdquo; it can also be &ldquo;owned&rdquo; as an NFT.</p>"
    :download "../research/art/not-the-worlds-first-collaborative-sentence.zip"
    :resource-url "https://hicetnunc.art/objkt/605464"
    :img-url "img/gift-shop/not-making-worlds-first-collaborative-sentence.png"
    :img-alt "&ldquo;Not Making the World's First Collaborative Sentence&rdquo; Thumbnail"
    :license "MIT License"
    :license-url "../research/art/not-the-worlds-first-collaborative-sentence/license.txt"}
   :the-slip
   {:item-name "The Slip"
    :attribution "Nine Inch Nails"
    :medium "Audio"
    :description "<blockquote>&ldquo;The Slip&rdquo; is the seventh studio album by American industrial rock act Nine Inch Nails, released on May 5, 2008 via digital download. Described by Reznor as &ldquo;Garage Electronics,&rdquo; &ldquo;The Slip&rdquo; was the result of an inspired three weeks following the completion of Ghosts I-IV.  An experiment in working with a compressed timeline, the results make for a noisy, sloppy and exciting listen with several songs that have been live staples.</blockquote>~ Nine Inch Nails, <a href=&ldquo;https://www.nin.com/music/the-slip/&rdquo;>Official Website</a>/Wiki"
    :resource-url "https://www.nin.wiki/The_Slip"
    :img-url "img/gift-shop/the-slip.jpg"
    :img-alt "&ldquo;The Slip&rdquo; Cover"
    :license "Attribution-NonCommercial-ShareAlike 3.0 United States (CC BY-NC-SA 3.0 US)"
    :license-url "https://creativecommons.org/licenses/by-nc-sa/3.0/us/"}
   :apollo-11
   {:item-name "Apollo 11 Guidance Computer Source Code"
    :attribution "NASA, Ron Burkey, et al."
    :medium "Software"
    :description "Original Apollo 11 guidance computer (AGC) <a href=&ldquo;https://schmud.de/posts/2021-09-07-fix-my-code.html&rdquo;>source code</a> for Command Module (Comanche055) and Lunar Module (Luminary099).<blockquote>Former NASA intern Chris Garry has posted the entire Apollo Guidance Computer source code on GitHub, giving you a good peek at the software that took NASA to the Moon. As Reddit users point out, it's clear that the developers had a mighty sense of humor -- line 666 of the lunar landing turns up a &ldquo;numero mysterioso,&rdquo; and there's even a reference to radio DJ Magnificent Montague's classic &ldquo;burn, baby, burn.&rdquo;</blockquote> ~ <a href=&ldquo;https://www.engadget.com/2016-07-10-apollo-11-source-code-on-github.html&rdquo;>Jon Fingas</a> (2016)<p>The code can be run in an <a href=&ldquo;http://ibiblio.org/apollo/index.html&rdquo;>emulation project</a> spearheaded by Ron Burkey.</p>"
    :resource-url "http://ibiblio.org/apollo/index.html"
    :img-url "img/gift-shop/apollo-f-8.jpg"
    :img-alt "Apollo display and keyboard unit. Photo by NASA/Dennis Taylor."
    :license "CC0"
    :license-url "https://creativecommons.org/publicdomain/zero/1.0/"
    :img-license "Public Domain"
    :img-license-url "https://www.dfrc.nasa.gov/Gallery/Photo/F-8DFBW/HTML/EC96-43408-1.html"}
   })


(defn make-shop-image [root {item-name :item-name resource-url :resource-url img-url :img-url img-alt :img-alt}]
  [:figure.dib {:vocab "http://schema.org/" :typeof "ImageObject"}
   [:a {:href resource-url}
    [:img {:alt img-alt :title img-alt :src (str root img-url) :property "contentUrl"}]]
   [:figcaption
    [:i img-alt] "&nbsp;"]
   [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]])

(defn make-shop-info [{item-name :item-name attr :attribution medium :medium desc :description download :download license :license license-url :license-url}]
  [:span
   [:h3 item-name]
   [:p medium]
   [:p attr]
   [:p desc]
   [:p [:a {:href download} "download"]]
   [:small
    [:a {:href license-url} [:p license]]]])

(defn gift-shop [root]
  (let [shop-item-layout :div.w-25-ns.w-40-m.w-100.pa3]
    [:div {:itemscope "itemscope", :itemtype "http://schema.org/BlogPosting"}
     [:meta {:content "David Schmudde", :itemprop "author"}]
     [:h1 {:id "gift-shop"}
      "The Gift Shop"]
     [:p "Welcome to the Gift Shop"]
     [:p "Gallery 404 is making a statement about digital objects and their value. It clearly states that we are not taking the preservation of digital culture seriously enough. A more subtle observation is that digital culture that is not free (as in libre, not as in beer) decays faster. The most prominent example are creative works done in non-free technologies like Flash. Gallery 404 exhibits many of these. The shop should re-enforce these concepts so Gallery 404 can be a complete artwork. I can also see room for inexpensive/free digital objects. Perhaps a self-erasing software notebook?"]
     [:div.flex.flex-wrap
      [shop-item-layout
       (make-shop-image root (:fix-my-code shop-items))]
      [shop-item-layout
       (make-shop-info (:fix-my-code shop-items))]
      [shop-item-layout
       (make-shop-image root (:first-online-sentence shop-items))]
      [shop-item-layout
       (make-shop-info (:first-online-sentence shop-items))]
      [shop-item-layout
       (make-shop-image root (:the-slip shop-items))]
      [shop-item-layout
       (make-shop-info (:the-slip shop-items))]
      [shop-item-layout
       (make-shop-image root (:apollo-11 shop-items))]
      [shop-item-layout
       (make-shop-info (:apollo-11 shop-items))]

      ]
     ])
  )
