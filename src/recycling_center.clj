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
       [:iframe {:srcdoc "<html><head><title>Light on the Net Project [Historical Album]</title></head><body bgcolor=\"#000000\" text=\"#dddddd\" link=\"#5050f0\" vlink=\"#c050b0\" alink=\"#909000\"><p><center><table><tr><td valign=\"top\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/title.gif\" height=\"200\" width=\"119\" alt=\"light\"></td><td align=\"center\"><font size=\"10\" color=\"#f0e060\"><b>Light on the Net project</b></font><br><font size=\"4\" color=\"#f08000\">Finally the system has been activated on 9th of June 1996</font></td></tr></table></center><p><br><p><br><font size=\"+1\">These pictures are taken on the midnight of 31th of May 1996 at the hall of Gifu Softopia Center.<br><p>Each light is a 20W bulb. These 49 lights are controlled by a MicroChip Controller which reads data from a PC through an RS-422 line. light.softopia.pref.gifu.jp is an IBM-PC/AT compatible with Pentium 90MHz and Windows 95. This PC sends commands to the MicroChip Controller, captures video images, and processes your requests.<br><p>These pictures are taken on the midnight of 31th of May 1996 at the hall of Gifu Softopia Center.<br></font><p><center><table><tr><td colspan=\"4\" align=\"center\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/03.jpeg\" width=\"188\" height=\"250\" alt=\"constructing\"></td></tr><tr></tr><tr></tr><tr><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/06.jpeg\" width=\"90\" height=\"120\" alt=\"PC/AT\"></td><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/02.jpeg\" width=\"90\" height=\"120\" alt=\"Mr.Yamamoto\"></td><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/09.jpeg\" width=\"90\" height=\"120\" alt=\"light\"></td><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/04.jpeg\" width=\"90\" height=\"120\" alt=\"Mr.Kawashima\"></td></tr></table></center><p><br><hr width=\"50%\"><br><center><font size=\"+1\"><a href=\"jojo/\"><b>Project Detail (in Japanese)</b></a></font></center><br><hr width=\"50%\"><br><p><br><font size=\"+1\">This project was made possible in collaboration with <a href=\"https://web.archive.org/web/20000301125959/http://www.softopia.pref.gifu.jp/\"><b>Gifu Softopia Japan</b></a>.</font><p><br><table><tr><td>Idea:</td><td>Masaki Fujihata + Ryouko Sukegawa</td></tr><tr><td>Design:</td><td>Masaki Fujihata</td></tr><tr><td>Server program:</td><td>Takeshi Kawashima</td></tr><tr><td>Circiut design:</td><td>Takeshi Kawashima + Masaki Iwata</td></tr><tr><td>Thanks to:</td><td>Hiroya Kubo, Nobuya 'Zuckey' Suzuki,<br>Shirou Yamamoto, Nobutaka Iwasaki,<br>Hiroyuki Takahashi</td></tr></table><p><br><font size=\"+1\">Questions are welcome to: <a href=\"https://web.archive.org/web/20000301125959/mailto:light@flab.sfc.keio.ac.jp\">light@flab.sfc.keio.ac.jp</a><br></font><p><br><h3 align=\"RIGHT\"><a href=\"https://web.archive.org/web/20000301125959/http://light.softopia.pref.gifu.jp/\">Light on the Net Project [Light Control]</a></h3><h3 align=\"RIGHT\"><a href=\"https://web.archive.org/web/20000301125959/http://www.flab.mag.keio.ac.jp/\">Masaki Fujihata Lab. Home Page</a></h3><p></body></html>" :width "100%" :height "500px"}]
       #_[:figure {:vocab "http://schema.org/" :typeof "ImageObject"}
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
     [:h3 [:i "Light on the Net&nbsp;"] "Website (1996)"]
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
   [:article.flex.justify-center
    [:div.flex.flex-column.justify-center.items-center.pv4
     [:div
      [:img {:src (str resource-url "img/recycling-center/loading-gif.webp")
             :id "loading-animation"
             :width "20px" :property "contentUrl"}]]
     #_[:div.w-100
        [:img {:src (str resource-url "img/recycling-center/smash-illiac-iv.jpg") :property "contentUrl"}]]
     [:div
      [:a {:href "recycling-center-artifacts.html"}
       [:button {:id "recycle-button" :disabled true} "READY!"]]]]]
       [:script "document.addEventListener('DOMContentLoaded', (event) => {
        setTimeout(() => {
          document.getElementById('recycle-button').disabled = false;
          document.getElementById('loading-animation').hidden = true;
        }, 3000);
      });
    "]
   ])

(defn artifacts [resource-url]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "Choose the Most Accurate Artifact"]
   [:article.flex.items-center
    [:div.w-50.pa3.tc
     [:img {:src (str resource-url "img/recycling-center/1.png")}]
     [:a {:href "recycling-center-final-1.html"} [:button "Version 1"]]]
    [:div.w-50.pa3.tc
     [:img {:src (str resource-url "img/recycling-center/2.png")}]
     [:a {:href "recycling-center-final-2.html"} [:button "Version 2"]]]]])

(defn final [resource-url path-to-artifact]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "Art!"]
   [:article ;; TODO: images are served from `../resources/img/recycling-center/1/constructing.png` so they don't currently work
    [:iframe {:srcdoc (slurp path-to-artifact)
              :width "100%" :height "500px"}]
    [:div.w-100.flex.justify-center.items-center.pv4
     [:a {:href "recycling-center.html"} [:button "Again"]]]]])
