(ns recycling-center
  (:require [utils :as u]
            [hiccup.page :as page]))

(defn intro [resource-url]
  (let [art {:title "Light on the Net Project"
             :url "http://light.softopia.pref.gifu.jp/"
             :artist "Masaki Fujihata"
             :date "1996"
             :retrieved "2023-04-23"
             :image "light-on-the-net-2023-04-23 22-40-53.png"
             :link-from "ArtByte"
             :link-from-url "https://web.archive.org/web/20030621040732/http://artbyte.com/web/net_pick/np_090101.html"
             :desc "A work by Masaki Fugihata is enjoyable in part because it is immediately gratifying. Shown in real-time 24 hours a day, it allows viewers to click the lightbulbs in a grid on and off, controlling the bulbs in an actual sculpture located in an office building in Japan."
             :desc-source "https://web.archive.org/web/20030621040732/http://artbyte.com/web/net_pick/np_090101.html"
             :notes "Lev Manovich quote: http://www.manovich.net/IA/telecommunication.html"
             :tech "49 20w lightbulbs. IBM-PC/AT compatible, Pentium 90MHz, and Windows 95 sending commands to MicroChip Controller via a RS-422 line, capturing video images, and processing requests."
             :current-archive "Internet Archive"
             :current-archive-url "https://web.archive.org/web/20000301125959/http://www.flab.mag.keio.ac.jp/light/album.html"
             :current-archive-type :host}
        img-url (u/get-image-url resource-url art)
        current-archive (:current-archive art)]
    [:div.cf.ph3.ph5-ns.pv3
     [:h1 "Broken Artwork"]
     [:article
      ;; image
      [:div.fn.fl-ns.w-60-l.pr4-l
       [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
        [:img {:alt (:title art) :title resource-url :src img-url :property "contentUrl"}]
        [:figcaption
         [:small.fr
          [:a.link {:href (:url art)}  "retrieved " (:retrieved art)]]
         [:i (:title art)] "&nbsp;"]]]
      ;; info
      [:div.fn.fl-ns.w-40-l.pt3.pt0-l
       [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  (:title art)]
       [:div
        [:p.f3.mid-gray.lh-title (:artist art) [:br]
         [:time.f6.ttu.tracked.gray (:date art)]]
        [:blockquote.ml0.mt0.pl3.black-90.bl.bw2.b--blue [:p (:desc art)]]
        [:span
         [:cite.f6.ttu.tracked.fs-normal " ~ " [:a.link {:href (:desc-source art)} " ArtByte (2001)"]]
         [:span
            ", currently archived at "
            [:a.link {:href (:current-archive-url art)} current-archive]]
         ]
]]]
     [:div.w-100.flex.justify-center.items-center.pv4 [:a {:href "recycling-center-materials.html"} [:button "RECYCLE!"]]]]))

(defn materials [resource-url]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "Recycling Center"]
   [:article
      ;; Electrons
    [:div.fn.fl-ns.w-50-l.pr4-l
     [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  "Waves"]
     [:h3 "Source HTML"]
     [:pre.overflow-hidden "&lt;title&gt;Light on the Net Project [Historical Album]&lt;/title&gt;&lt;/head&gt;
&lt;body bgcolor=&quot;#000000&quot; text=&quot;#dddddd&quot; link=&quot;#5050f0&quot; vlink=&quot;#c050b0&quot; alink=&quot;#909000&quot;&gt;
&lt;table&gt;
&lt;tr&gt;
&lt;td valign=&quot;top&quot;&gt;
&lt;img src=&quot;/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/title.gif&quot; height=&quot;200&quot; eidth=&quot;119&quot; wlt=&quot;light&quot;&gt;&lt;/td& gt;
"]
     [:p [:small "source:&nbsp;" [:a {:href "https://web.archive.org/web/20000301125959/http://www.flab.mag.keio.ac.jp/light/album.html"} "internet archive"]]]
     [:h3 "NCSA HTTPd Server 1.5.2 (1996)"]
     [:pre.overflow-hidden "while(!Exit) {
  /* current_process_size(&quot;Starting&quot;); */
  initialize_socket(&sa_server,&sa_client);
  set_signals();
  speed_hack_libs();
  log_pid();"]
     [:p [:small "source:&nbsp;" [:a {:href "https://archive.softwareheritage.org/browse/content/sha1_git:2d13e113b33364a93998706aa74b4a92b3fabf6c/?origin_url=https://github.com/unix-history/ncsa-httpd&path=src/httpd.c"} "software heritage"]]]
     [:h3 "NCSA Mosaic 2.7 (1995)"]
     [:pre.overflow-hidden "typedef struct map_rec {
	char *name;
	AreaInfo *areaList;
	AreaInfo *currentArea;
	struct map_rec *next;
      } MapInfo;"]
     [:p [:small "source:&nbsp;" [:a {:href "https://archive.softwareheritage.org/browse/content/sha1_git:5be62e43600defe91de284fc5599d1c0369c5a5d/?origin_url=https://github.com/alandipert/ncsa-mosaic&path=libhtmlw/HTML.h"} "software heritage"]]]
     [:p "We were able to salvage these materials."]

     [:div.w-100.flex.justify-center.items-center.pv4
      [:a {:href "recycling-center-recycling.html"} [:button "RECYCLE!"]]]]
    [:div.fn.fl-ns.w-50-l.pr4-l
     [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  "Particles"]
     [:h3 "Infrastructure"]
     [:ul
      [:li "Copper wire"]
      [:li "Computer (Japan)"]
      [:li "Ethernet hub and switches"]
      [:li "Computer (Client)"]
      [:li "Modem"]]
     [:h3 "Custom Installation"]
     [:ul
      [:li "Lights and electrical"]
      [:li "Scaffolding"]]
     [:p "All landfill dumping is automated."]

     [:div.w-100.flex.justify-center.items-center.pv4
      [:a {:href ""} [:button {:disabled true} "LANDFILL"]]]]]])

(defn recycling [resource-url]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "Recycling"]
   [:article
    [:div.w-100.flex.justify-center.items-center.pv4
     [:div.w-100
      [:img {:src (str resource-url "img/recycling-center/loading-gif.webp") :width "20px" :property "contentUrl"}]]
     [:div.w-100
      [:img {:src (str resource-url "img/recycling-center/smash-illiac-iv.jpg") :property "contentUrl"}]]
     [:div.w-100
      [:a {:href "recycling-center-artifacts.html"} [:button "READY"]]]]]])

(defn artifacts [resource-url]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "Choose the Most Accurate Artifact"]
   [:article
    [:div.w-100.flex.justify-center.items-center.pv4
     [:a {:href "recycling-center-final.html"} [:button "1"]]
     [:a {:href "recycling-center-final.html"} [:button "2"]]
     [:a {:href "recycling-center-final.html"} [:button "3"]]]]])


(defn final [resource-url]
    (let [art {:title "Light on the Net Project"
             :url "http://light.softopia.pref.gifu.jp/"
             :artist "Masaki Fujihata"
             :date "1996"
             :retrieved "2023-04-23"
             :image "light-on-the-net-2023-04-23 22-40-53.png"
             :link-from "ArtByte"
             :link-from-url "https://web.archive.org/web/20030621040732/http://artbyte.com/web/net_pick/np_090101.html"
             :desc "<blockquote>By foregrounding telecommunication, both real-time and asynchronous, as a fundamental cultural activity, IT culture asks us to reconsider the very paradigm of what an aesthetic object is. Is it necessary for the concept of the aesthetics to assume representation? Does art necessarily involve a finite object?...In short, if a user accessing information and a user telecommunicating with other(s) are as common in computer culture as a user interacting with a representation, can we expand our aesthetic theories to include these two new situations?</blockquote> ~ <i>Culture without Objects, or Representation versus Telecommunication</i>, Lev Manovich <br /><br />With increased bandwidth becoming the norm rather than the exception, artists like Ken Goldberg and Eduardo Kacs will have even more opportunities to clearly defy the finality of the object and eliminate the author. Goldberg's Telegarden (http://telegarden.aec.at/) is a brilliant, life-affirming example of dispersed authority, but it requires patience. A work by Masaki Fugihata is enjoyable in part because it is immediately gratifying. Shown in real-time 24 hours a day, it allows viewers to click the lightbulbs in a grid on and off, controlling the bulbs in an actual sculpture located in an office building in Japan."
             :desc-source "https://web.archive.org/web/20030621040732/http://artbyte.com/web/net_pick/np_090101.html"
             :notes "Lev Manovich quote: http://www.manovich.net/IA/telecommunication.html"
             :tech "49 20w lightbulbs. IBM-PC/AT compatible, Pentium 90MHz, and Windows 95 sending commands to MicroChip Controller via a RS-422 line, capturing video images, and processing requests."
             :current-archive "Internet Archive"
             :current-archive-url "https://web.archive.org/web/20000301125959/http://www.flab.mag.keio.ac.jp/light/album.html"
             :current-archive-type :host}
        img-url (u/get-image-url resource-url art)
        current-archive (:current-archive art)]

  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "Art!"]
   [:article
    [:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
      [:img {:alt (:title art) :title resource-url :src img-url :property "contentUrl"}]
      [:figcaption
       [:small.fr
        [:a.link {:href (:url art)}  "retrieved " (:retrieved art)]]
       [:i (:title art)] "&nbsp;"]]
    [:div.w-100.flex.justify-center.items-center.pv4
     [:a {:href "recycling-center.html"} [:button "Again"]]]]]
  )
)
