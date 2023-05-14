(ns news)

(defn press-release [root]
  (let [gift-shop (slurp "resources/news/gift-shop-press-release.txt")]
    [:article [:div [:pre.press-release gift-shop]]]))
