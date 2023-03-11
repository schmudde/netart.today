(ns gift-shop
  (:require [clojure.string :refer [lower-case]]
            [clojure.edn :as edn]))

(defn make-shop-image [root {resource-url :resource-url img-url :img-url img-alt :img-alt item-name :item-name}]
  [:figure.db.gift-shop-image.center {:vocab "http://schema.org/" :typeof "ImageObject"}
   [:a {:href resource-url}
    [:img {:alt img-alt :title img-alt :src (str root img-url) :property "contentUrl"}]]
   [:figcaption
    [:small [:i img-alt] "&nbsp;"]]
   [:meta {:property "acquireLicensePage" :content "https://schmud.de/pages/about.html"}]])

(defn make-tags [tags]
  (->
   (mapv #(str "#" (lower-case %) ", ") (butlast tags))
   (conj (str "#" (lower-case (last tags))))))

(defn make-shop-info [root {item-name :item-name attr :attribution medium :medium desc :description download :download license :license license-url :license-url year :year}]
  [:span
   [:h2.lh-copy item-name]
   [:p "by " [:strong attr] (when year (format " (%d)" year))]
   [:small [:i {:class "fa fa-tags"}] "&nbsp;" (reduce str (make-tags medium))]
   [:p desc]
   (when download
     [:p [:i {:class "fa fa-download"}] "&nbsp;" [:a {:href (str root download)} "download"]])
   [:small [:i {:class "fas fa-balance-scale"}] "&nbsp;" [:a {:href license-url} license]]])

(defn gift-shop [root]
  (let [shop-items (edn/read-string (slurp "resources/gift-shop.edn"))
        shop-item-layout :div.w-25-ns.w-50-m.w-100.pa3]
    (println (first shop-items))
    [:div {:itemscope "itemscope", :itemtype "http://schema.org/BlogPosting"}
     [:meta {:content "David Schmudde", :itemprop "author"}]
     [:h3 "Welcome to the Gift Shop"]
     [:p "These pieces exist beyond the law. They cannot be owned or contained. They are directly sustained by the will of the people. They are modified and shared without a corporate middleman."]
     [:p "These are living works which age differently than works strangled by copyright. They are the result of creativity without borders."]
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
      [shop-item-layout
       (make-shop-image root (:magic-catalog shop-items))]
      [shop-item-layout
       (make-shop-info root (:magic-catalog shop-items))]
      [shop-item-layout
       (make-shop-image root (:winnie-the-pooh shop-items))]
      [shop-item-layout
       (make-shop-info root (:winnie-the-pooh shop-items))]]]))
