(ns user
  (:require [nextjournal.clerk :as clerk]))

(comment
  ;; start file watcher, open browser when started
  (clerk/serve! {:browse? true :watch-paths ["dev" "src"]})


  ;; do live coding










































  (do ;; start over without file watcher
    (reset! nextjournal.clerk.webserver/!doc nextjournal.clerk.webserver/help-doc)
    (clerk/serve! {:browse? true :watch-paths ["notebooks"]}))

  (clerk/clear-cache!)

  (clerk/show! "notebooks/tap.clj")


  (clerk/show! "notebooks/rule_30.clj")



  (clerk/show! "notebooks/dice.clj")




  (clerk/show! "notebooks/sicmutils.clj")



  (clerk/show! "notebooks/semantic.clj")



  ;; produce a static app
  (clerk/build-static-app! {:paths ["notebooks/semantic.clj"
                                    "notebooks/how_clerk_works.clj"]})

  (clojure.java.browse/browse-url "https://app.netlify.com/drop/")
  (clojure.java.browse/browse-url "public")

  ;; produce a static app
  (clerk/build-static-app! {:paths (mapv #(str "notebooks/" % ".clj")
                                         '[introduction data_science rule_30 semantic])})

  )
