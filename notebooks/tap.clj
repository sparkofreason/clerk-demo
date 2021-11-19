;; # 🚰 Tap Inspector
(ns tap
  (:require [clojure.string :as str]
            [nextjournal.clerk :as clerk]))

(defonce !taps (atom ()))

^::clerk/no-cache @!taps

(declare tapped words)

(comment

  (tap> (rand-int 1000000))

  (tap> (shuffle (range 100)))

  (tap> (zipmap (range 100) (range 100 1 -1)))

  (tap> (set (take 5 (shuffle (str/split-lines (slurp "/usr/share/dict/words"))))))

  )


(defn tapped [x]
  (binding [*ns* (find-ns 'user)]
    (swap! !taps conj x)
    (clerk/show! "notebooks/tap.clj")))

(defonce setup
  (add-tap tapped))

#_(do (reset! !taps ()) (clerk/show! "notebooks/tap.clj"))
