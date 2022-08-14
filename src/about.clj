(ns about)

;; <!-- https://github.com/weavejester/hiccup/wiki/Converting-html-to-hiccup -->

(defn about-article [root]
  [:article {:itemscope "itemscope", :itemtype "http://schema.org/BlogPosting"}
   [:meta {:content "David Schmudde", :itemprop "author"}]
   [:p "Welcome to Gallery 404. We exclusively specialize in broken artworks. None of the works are for sale. You will find the exit just past the gift shop."]
   [:h1 {:id "about-gallery-404"}
    "About Gallery 404"]
   [:p "net.art is artwork that is made for the internet. It is handcrafted and the results "
    [:em "happen"] " in cyberspace, an ephemeral place between machines."]
   [:figure
    [:img.db.center {:src (str root "img/netartdiagram.gif") :alt "Simple Net Art Diagram MTAA (1997)"}]
    [:figcaption.tc.f6 [:a.link {:href "http://www.mtaa.net/mtaaRR/off-line_art/snad.html"}
                  [:em "Simple Net Art Diagram"]] " MTAA (1997) "
     [:small
      [:span {:property "license"}
       [:a.link.link {:href "https://creativecommons.org/licenses/by/2.5/" :rel "license"} [:i {:class "fab fa-creative-commons"}] "&nbsp;" [:i {:class "fab fa-creative-commons-by"}]]]
      "&nbsp;"]]]
   [:p
    [:a.link {:href "http://www.netart.today/"}
      "Gallery 404"] " collects and displays screenshots and hyperlinks to prominent net.art artworks on the world wide web. These links point to a place where net.art "
    [:em "happened"] ". The links are displayed along side of more traditional media: written biographical information and images of the artwork’s current state."]
    [:p "The holdings of Gallery 404 no longer function as the artists originally intended. Each artwork has yielded to the passing of time. In a medium where calculations are made at unimaginable speeds, time itself seems to pass faster. Some of these artworks took less than a decade to decay into unrecognizable states."]
    [:p "Gallery 404 is net.art today. Much of what was created by the first generation of digital natives is now broken. While some works of net.art have benefited from institutional preservation, even these are vulnerable to software updates, infrastructure changes, and negligence." [:a.link {:href "#fn-1"} "[1]"]
      " As software eats the world, it also consumes itself."]
    [:h1 {:id "the-preservation-of-net.art"}
     "The Preservation of net.art"]
    [:p "net.art is a peculiar art form. Its growth paralleled the emergence of the commercial internet. The lack of a formal language or framing device made the work difficult to spot; “art” websites and “non-art” websites looked similar. There were few celebrity practitioners and virtually no exhibition spaces."]
    [:p "The net.art movement liberated artists and audiences from Duchamp-style Modernism. Duchamp's Modernism crystallized when the artist submitted"
     [:em " Fountain"] ", a urinal bought at a hardware store in Manhattan, to the Society of Independent Artists exhibit in 1917."
     [:em " Fountain "] "brought the power of art-signifying frames to the forefront: “this urinal is art because it is being exhibited as art.”"]
    [:p "net.art lacked an equivalent to trendy exhibition spaces, deliberate lighting, and expensive picture frames. The blurred boundaries were reflected in pieces such as "
     [:em [:a.link {:href "https://sites.rhizome.org/anthology/airworld.html"}
      "Airworld"]] " and website awards like Alexei Shulgin’s"
     [:em [:a.link {:href "http://www.easylife.org/award/"}
      " WWWART MEDAL"]] ", which presented “non-art” websites awards for providing a “definite ‘art’ feeling.”"
     [:a.link {:href "#fn-2"} "[2]"]]
    [:p "While much has been written on how the “"
     [:a.link {:href "https://www.nytimes.com/2010/07/25/magazine/25privacy-t2.html"}
      "internet never forgets"] "”, much of what was created in the last twenty plus years has disappeared from neglect or deliberate corporate purging. This includes countless websites, Flickr (2019), and Tumblr (2018) accounts, all of Google+ (2019), all of Geocities (2009), and 50 million songs by 14 million artists on MySpace (2003-2015)."
     [:a.link {:href "#fn-3"} "[3]"]]
    [:p "net.art was a generation's attempt to plant a cultural stake in cyberspace. Their work is a reflection of what the internet was and could be. But the cultural artifacts of the first digital natives are quickly being lost to time. Gallery 404 presents this broken history in its unvarnished reality."]
    [:h1 {:id "historical-context"}
     "Historical Context"]
    [:p "The world wide web is just one part of the internet. Some historical context will help convey the difference between net.art and the "
     [:a.link {:href "https://en.wikipedia.org/wiki/Telematic_art"}
      "telematic art"] " that existed in the years prior."
     [:a.link {:href "#fn-4"} "[4]"]]
    [:ul.pl4-ns.pl2
     [:li "30 August 1969: the ARPANET, an early "
      [:strong "military computer network"] ", comes online in the United States. The network is used to coordinate information and share computing resources."]
     [:li "15 July 1980: Minitel, a popular "
      [:strong "public computer network"] ", comes online in France. This network is used to provide online services to the "
      [:strong "general public"] "."]
     [:li "1 January 1983: the ARPANET adopts TCP/IP, the fundamental protocol of today’s "
      [:strong "internet"] ". The usage of the internet expands to fulfill many "
      [:strong "governmental and academic interests"] "."]
     [:li "12 March 1989: Tim Berners-Lee proposes the "
      [:strong "world wide web"] " (www) in "
      [:em "Information Management, a Proposal"] "."]
     [:li "6 August 1991: Tim Berners-Lee publishes the first "
      [:strong "website"] " on the "
      [:strong "internet"] "."]
     [:li "2 October 1992: the "
      [:a.link {:href "https://www.congress.gov/bill/102nd-congress/senate-bill/1146"}
       "Scientific and Advanced-Technology Act"] " is passed, allowing the US taxpayer-funded internet backbone to “be used substantially for additional purposes”"
      [:strong " beyond research and education"] " (i.e. commercial use)."]
     [:li "April 1995: the "
      [:strong "world wide web becomes the most popular protocol"] " on the internet backbone (NSFNET 35)."]
     [:li "30 April 1995: the public internet backbone (NSFNET 41) is officially decommissioned, marking the birth of today’s "
      [:strong "commercial internet"] "."]
     [:li "1998: the Museum of Modern Art acquires its first "
      [:strong "born-digital "] " artwork, " [:strong "Teiji Furuhashi "] [:em "Lovers "] "(1994)." [:a.link {:href "#fn-5"} "[5]"]]
     [:li "2000: the Museum of Modern Art acquires its first "
      [:strong "interactive software "] "artwork, " [:strong "Cedric Price "]
      [:em "Generator Project, White Oak, Florida (Five Enclosures, Model and Baseboard) "] "(1978-80)." [:a.link {:href "#fn-6"} "[6]"]]]
    [:p "net.art arrives in the early 1990s, after the invention of the world wide web and the legislative move to open the internet up for “additional purposes.” Artists immediately created work that reflected the cultural milieu of the time. For example, as the internet started to shift from interoperable public spaces to siloed corporate spaces by the turn of the millennium, parallel concerns about the corporatization of the internet are reflected in prominent net.art artworks like "
     [:em [:a.link {:href "http://history.etoy.com/stories/entries/49/index.html"}
      "Toywar"]] " (1999) and the aforementioned "
     [:em [:a.link {:href "https://sites.rhizome.org/anthology/airworld.html"}
      "Airworld"]] " (1999). "]
    [:p "It can be difficult to see a technology’s implicit political bias decades removed from its use. Today’s centralized algorithms for search (Google) and social (Facebook) are fundamentally different than yesterday’s homespun"
     [:a.link {:href "https://en.wikipedia.org/wiki/Webring"}
      " webring"] ". Cultural artifacts are the best evidence of what kind of internet is not only possible, but just as plausible."]
    [:h1 {:id "about-the-curator"}
     "About the Curator"]
    [:p "David Schmudde writes about information and technology in the public interest at "
     [:a.link {:href "https://schmud.de/"}
      "Beyond the Frame"] ". He worked as an artist in Chicago and New York City for over a decade. He has since moved to Europe to work on problems in open science, digital identity, and software preservation."]

   [:h1 "Footnotes"]
   [:ol.pl4-ns.pl2
    [:li {:id "fn-1"}
       " The Whitney’s "
       [:a.link {:href "https://whitney.org/artport/douglas-davis"}
        "2013 restoration"] " of "
       [:em "The World’s First Collaborative Sentence"] " (Douglas Davis 1994) is probably the most salient example. As of January 2021, it no longer functions properly."]
    [:li {:id "fn-2"}
       "Kenta Murakami, “"
       [:a.link {:href "https://www.digitalamerica.org/the-demise-of-net-art-a-look-at-artifacts-past-kenta-murakami/"}
        "The Demise Of Net.Art: A Look at Artifacts Past"] "”, "
       [:em "Digital America"] ", 2013."]
    [:li {:id "fn-3"}
       "This is in spite of the best efforts of the "
       [:a.link {:href "http://archiveteam.org/"}
        "Archive Team"] ", the "
       [:a.link {:href "https://archive.org"}
        "Internet Archive"] ", and similar initiatives around the world. Hamza Shaban, “"
       [:a.link {:href "https://www.seattletimes.com/business/loss-of-old-myspace-artifacts-highlights-the-impermanence-of-the-web/"}
        "Loss Of Old Myspace Artifacts Highlights The Impermanence Of The Web"] "”, "
       [:em "The Seattle Times"] ", 2019. Vivian Le, “"
       [:a.link {:href "https://99percentinvisible.org/episode/the-lost-cities-of-geo/"}
        "The Lost Cities of Geo"] "”, podcast, "
       [:em "99% Invisible"] ", 2020."]
    [:li {:id "fn-4"}
       "Karen D. Frazer, "
       [:a.link {:href "https://www.merit.edu/wp-content/uploads/2019/06/NSFNET_final-1.pdf"}
        [:em "NSFNET: A Partnership for High-Speed Networking, Final Report 1987-1995"]
        ] " (Merit Network, Inc., 1995). Jay Hoffmann, “"
       [:a.link {:href "https://thehistoryoftheweb.com/timeline/?date_from=1989&date_to=1994"}
        "The Web’s Timeline 1989-1994"] "”, " [:em "The History of the Web"] ", 2020."]
    [:li {:id "fn-5"}
       "Ben Fino-Radin on "
       [:a.link {:href "https://twitter.com/benfinoradin/status/1452920444185726979?s=21"}
        "Twitter"] ", Museum of Modern Art "
       [:a.link {:href "https://www.moma.org/collection/works/81362"}
        "Object number 331.1998"] ]
    [:li {:id "fn-6"}
       "Ben Fino-Radin on "
       [:a.link {:href "https://twitter.com/benfinoradin/status/1452920444185726979?s=21"}
         "Twitter"] ", Museum of Modern Art "
       [:a.link {:href "https://www.moma.org/collection/works/870"}
        "Object number 1255.2000"]]
    ]

   ])
