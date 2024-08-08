(ns recycling-center
  (:require [utils :as u]
            [hiccup.page :as page]))

(def light-on-the-net
  {:title "Light on the Net Project"
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
   :current-archive-type :host})

(defn intro [_]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "The net.art Restoration Project"]
   [:div.w-100.flex.flex-column.pv3
    [:p.f3.fw9.mb4.mt0 "The world wide web is in decay. Much of what was created over its lifetime has disappeared from neglect or deliberate corporate purging."]]
   [:article
    [:div.fn.fl-ns.w-60-l.pr4-l
     [:p.b "Original Art"]
     [:figure #_{:vocab "http://schema.org/" :typeof "ImageObject"}
      [:iframe {:srcdoc "<html><head><title>Light on the Net Project [Historical Album]</title></head><body bgcolor=\"#000000\" text=\"#dddddd\" link=\"#5050f0\" vlink=\"#c050b0\" alink=\"#909000\"><p><center><table><tr><td valign=\"top\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/title.gif\" height=\"200\" width=\"119\" alt=\"light\"></td><td align=\"center\"><font size=\"10\" color=\"#f0e060\"><b>Light on the Net project</b></font><br><font size=\"4\" color=\"#f08000\">Finally the system has been activated on 9th of June 1996</font></td></tr></table></center><p><br><p><br><font size=\"+1\">These pictures are taken on the midnight of 31th of May 1996 at the hall of Gifu Softopia Center.<br><p>Each light is a 20W bulb. These 49 lights are controlled by a MicroChip Controller which reads data from a PC through an RS-422 line. light.softopia.pref.gifu.jp is an IBM-PC/AT compatible with Pentium 90MHz and Windows 95. This PC sends commands to the MicroChip Controller, captures video images, and processes your requests.<br><p>These pictures are taken on the midnight of 31th of May 1996 at the hall of Gifu Softopia Center.<br></font><p><center><table><tr><td colspan=\"4\" align=\"center\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/03.jpeg\" width=\"188\" height=\"250\" alt=\"constructing\"></td></tr><tr></tr><tr></tr><tr><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/06.jpeg\" width=\"90\" height=\"120\" alt=\"PC/AT\"></td><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/02.jpeg\" width=\"90\" height=\"120\" alt=\"Mr.Yamamoto\"></td><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/09.jpeg\" width=\"90\" height=\"120\" alt=\"light\"></td><td align=\"center\" width=\"120\" height=\"150\"><img src=\"/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/04.jpeg\" width=\"90\" height=\"120\" alt=\"Mr.Kawashima\"></td></tr></table></center><p><br><hr width=\"50%\"><br><center><font size=\"+1\"><a href=\"jojo/\"><b>Project Detail (in Japanese)</b></a></font></center><br><hr width=\"50%\"><br><p><br><font size=\"+1\">This project was made possible in collaboration with <a href=\"https://web.archive.org/web/20000301125959/http://www.softopia.pref.gifu.jp/\"><b>Gifu Softopia Japan</b></a>.</font><p><br><table><tr><td>Idea:</td><td>Masaki Fujihata + Ryouko Sukegawa</td></tr><tr><td>Design:</td><td>Masaki Fujihata</td></tr><tr><td>Server program:</td><td>Takeshi Kawashima</td></tr><tr><td>Circiut design:</td><td>Takeshi Kawashima + Masaki Iwata</td></tr><tr><td>Thanks to:</td><td>Hiroya Kubo, Nobuya 'Zuckey' Suzuki,<br>Shirou Yamamoto, Nobutaka Iwasaki,<br>Hiroyuki Takahashi</td></tr></table><p><br><font size=\"+1\">Questions are welcome to: <a href=\"https://web.archive.org/web/20000301125959/mailto:light@flab.sfc.keio.ac.jp\">light@flab.sfc.keio.ac.jp</a><br></font><p><br><h3 align=\"RIGHT\"><a href=\"https://web.archive.org/web/20000301125959/http://light.softopia.pref.gifu.jp/\">Light on the Net Project [Light Control]</a></h3><h3 align=\"RIGHT\"><a href=\"https://web.archive.org/web/20000301125959/http://www.flab.mag.keio.ac.jp/\">Masaki Fujihata Lab. Home Page</a></h3><p></body></html>" :width "100%" :height "500px"}]
      [:figcaption
       [:small.fr
        [:a.link {:href (:url light-on-the-net)}  "retrieved " (:retrieved light-on-the-net)]]
       [:i (:title light-on-the-net)] "&nbsp;(" (:date light-on-the-net) ")"]]]

    ;; info
    [:div.fn.fl-ns.w-40-l.pt3.pt0-l
     [:p.b.tr "About the Artwork"]
     [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  "&larr;"]
     [:p "This is " [:i "Light on the Net Project "] "from 1996. You can go ahead and click around. You'll see a lot of missing images, broken links, and unstructured text. But it's the best known copy of this piece. It's a shame because " [:i "Light on the Net Project "] "is a beautiful and important telematic work from the last century. "]
     [:p "Here's some historical context:"]
     [:div
      [:blockquote.ml0.mt0.pl3.black-90.bl.bw2.b--blue [:p (:desc light-on-the-net)]]
      [:span
       [:cite.f6.ttu.tracked.fs-normal " ~ " [:a.link {:href (:desc-source light-on-the-net)} " ArtByte (2001)"]]]]
     [:p "Digital artworks decay quickly. Over the next four screens I'll guide you through a restoration process to combat the mass loss of culture."]
     [:div.w-100.flex.flex-column.items-center.pv4
      [:div.tc.f2.dib.v-mid.items-center.dark-green "&rarr;&nbsp;"
       [:a.f5.grow.no-underline.br-pill.ba.bw2.ph3.pv2.glow.dark-green
        {:href "restoration-project-materials.html"} "RESTORE!"]
       "&nbsp;&larr;"]]]]])

(defn materials [_]
  [:div.cf.ph3.ph5-ns.pv3
   [:style
    ".gradient-bottom-edge {
        position: relative;
        overflow: hidden;
      }

      .gradient-bottom-edge::after {
        content: '';
        position: absolute;
        bottom: 0;
        left: 0;
        width: 100%;
        height: 60px;
        background: linear-gradient(to bottom, transparent, rgba(255, 255, 255, 1));
      }"]
   [:h1 "The net.art Restoration Project: Materials"]
   [:div.w-100.flex.flex-column.pv3.pr4-l
    [:p.f3.fw9.mb4.mt0 "Here is a condensed inventory of the materials used to build " [:i "Light on the Net Project. "] "A Large Language Model (LLM) will use what it can to restore the artwork." ]]
   [:article
      ;; Electrons
    [:div.fn.fl-ns.w-50-l.pr4-l
     [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  "Bits"]
     [:p "We were able to salvage these materials."]

     [:h3 [:i "Light on the Net&nbsp;"] "Website (1996)"]
     [:pre.overflow-hidden.gradient-bottom-edge "&lt;title&gt;Light on the Net Project [Historical Album]&lt;/title&gt;&lt;/head&gt;
&lt;body bgcolor=&quot;#000000&quot; text=&quot;#dddddd&quot; link=&quot;#5050f0&quot; vlink=&quot;#c050b0&quot; alink=&quot;#909000&quot;&gt;
&lt;table&gt;
&lt;tr&gt;
&lt;td valign=&quot;top&quot;&gt;
&lt;img src=&quot;/web/20000301125959im_/http://www.flab.mag.keio.ac.jp/light/Image/title.gif&quot; height=&quot;200&quot; eidth=&quot;119&quot; wlt=&quot;light&quot;&gt;&lt;/td& gt;
"]
     [:p [:small "source:&nbsp;" [:a {:href "https://web.archive.org/web/20000301125959/http://www.flab.mag.keio.ac.jp/light/album.html"} "internet archive"]]]
     [:h3 "NCSA HTTPd Server 1.5.2 (1996)"]
     [:pre.overflow-hidden.gradient-bottom-edge "while(!Exit) {
  /* current_process_size(&quot;Starting&quot;); */
  initialize_socket(&sa_server,&sa_client);
  set_signals();
  speed_hack_libs();
  log_pid();"]
     [:p [:small "source:&nbsp;" [:a {:href "https://archive.softwareheritage.org/browse/content/sha1_git:2d13e113b33364a93998706aa74b4a92b3fabf6c/?origin_url=https://github.com/unix-history/ncsa-httpd&path=src/httpd.c"} "software heritage"]]]
     [:h3 "NCSA Mosaic 2.7 (1995)"]
     [:pre.overflow-hidden.gradient-bottom-edge "typedef struct map_rec {
	char *name;
	AreaInfo *areaList;
	AreaInfo *currentArea;
	struct map_rec *next;
      } MapInfo;"]
     [:p [:small "source:&nbsp;" [:a {:href "https://archive.softwareheritage.org/browse/content/sha1_git:5be62e43600defe91de284fc5599d1c0369c5a5d/?origin_url=https://github.com/alandipert/ncsa-mosaic&path=libhtmlw/HTML.h"} "software heritage"]]]

    [:div.tc [:a.f6.grow.no-underline.br-pill.ba.bw2.ph3.pv2.mb2.dib.shadow-4.dark-green
              {:href "restoration-project-recycling.html"} "SALVAGE!"]]]

    [:div.fn.fl-ns.w-50-l.pr4-l
     [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  "Particles"]
     [:p "The location of these artifacts is unknown and cannot be salvaged."]
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
     ]]])

(defn restoring [resource-url]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "The net.art Restoration Project: Restore"]
   [:div.w-100.flex.flex-column.pv3
    [:p.f3.fw9.mb4.mt0 "LLMs have already looted our culture. In the absence of cultural governance, we have no choice but to relinquish the management of our digital artifacts to artificial intelligence. " [:i "Light on the Net Project "] "will soon be safeguarded by our new benevolent caretakers."]]
   [:article.flex.justify-center
    [:div.flex.flex-column.justify-center.items-center.pv4
     [:p "ChatGPT is working out the solution. " [:span#wait "Please wait."] [:span#finished {:style (str "display: " "none;") } "Finished!"]]
     [:div.pv2
      [:img {:src (str resource-url "img/restoration-project/loading-gif.webp")
             :id "loading-animation"
             :width "20px" :property "contentUrl"}]]

     [:div.pv2
      [:a {:href "restoration-project-artifacts.html"}
       [:button.f6.grow.no-underline.br-pill.ba.bw2.ph3.pv2.mb2.dib.shadow-4.dark-green.bg-white.b--dark-green {:id "restore-button" :disabled true} "RESTORE!"]]]

     ]]
       [:script "document.addEventListener('DOMContentLoaded', (event) => {
        setTimeout(() => {
          document.getElementById('restore-button').disabled = false;
          document.getElementById('restore-button').classList.add('glow');
          document.getElementById('loading-animation').hidden = true;
          document.getElementById('wait').hidden = true;
          document.getElementById('finished').style.display = 'inline';
        }, 3000);
      });
    "]
   ])

(defn artifact [resource-url position]
  (let [image (format "%simg/restoration-project/%s.png" resource-url position)
        page (format "restoration-project-final-%s.html" position)
        version (str "Version " position)]
    [:div.w-50-l.w-100.pa3.tc {:id (str "version-" position)}
     [:img {:src image}]
     [:div.pv3
      [:a.f6.grow.no-underline.br-pill.ba.bw2.ph3.pv2.mb2.dib.shadow-4.dark-green
      {:href page} version]]]))

(defn artifacts [no-of-artifacts resource-url]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1 "The net.art Restoration Project: Possible Objects"]
   [:div.w-100.flex.flex-column.pv3
    [:p.f3.fw9.mb4.mt0 "Our algorithms have created several options for a restored " [:i "Light on the Net Project. "] "Help train the LLM by selecting the best representation of this net.art classic. Don't worry if you are unfamiliar with the original artwork, we're all qualified to choose what is &quot;the best.&quot;" ]]
   [:article.flex.flex-wrap
    (map #(artifact resource-url %1) (range 1 (inc no-of-artifacts) 1))]])

(defn final [_ path-to-artifact]
  [:div.cf.ph3.ph5-ns.pv3
   [:h1.pb4 "The net.art Restoration Project: Restoration Complete!"]
   [:article ;; TODO: images are served from `../resources/img/restoration-project/1/constructing.png` so they don't currently work
    [:div.fn.fl-ns.w-60-l.pr4-l
     [:figure #_{:vocab "http://schema.org/" :typeof "ImageObject"}
      [:iframe {:srcdoc (slurp path-to-artifact)
                :width "100%" :height "500px"}]
      [:figcaption
       [:i (:title light-on-the-net)] "&nbsp;(" (:date light-on-the-net) ")"]]]
    ;; info
    [:div.fn.fl-ns.w-40-l.pt3.pt0-l
     [:h2.f2.lh-title.fw9.mb3.mt0.pt3.bt.bw2  (:title light-on-the-net)]
     [:div
      [:p.f3.mid-gray.lh-title (:artist light-on-the-net) [:br]
       [:time.f6.ttu.tracked.gray (:date light-on-the-net)]]
      [:blockquote.ml0.mt0.pl3.black-90.bl.bw2.b--blue [:p "&ldquo;Light on the Net&rdquo; by Masaki Fujihata is a pioneering interactive art installation. It allows users to control a grid of light bulbs in real-time via the internet, 24 hours a day. This interaction directly affects the physical installation located at the Ogaki City Art Museum in Gifu, Japan. The work exemplifies the fusion of digital and physical spaces, showcasing the potential of the internet as a medium for real-time global interaction."]]
      [:span
       [:cite.f6.ttu.tracked.fs-normal " ~ Leonardo, Journal of the International Society for the Arts, Sciences and Technology (2000)"]
       ]]]]
   [:div.w-100.flex.flex-column.items-center.pv4
    [:p.f3.fw9.mb3.mt0.pt3.bt.bw2 "Thank you for repairing this important artifact. Soon our entire cultural history will be mediated by artificial intelligence. We will no longer need to do the costly and difficult work of maintaining relics of the past. Not only will we be &quot;All Watched Over by Machines of Loving Grace&quot; as Richard Brautigan imagined in 1967, our understanding of the past and therefore our future will be seen through this infaliable algorithmic lens."]
    [:a.f6.grow.no-underline.br-pill.ba.bw2.ph3.pv2.mb2.dib.shadow-4.dark-green
     {:href "restoration-project.html"} "Again"]]])
