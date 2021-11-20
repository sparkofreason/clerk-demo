(ns user
  (:require [nextjournal.clerk :as clerk]))

(comment
  ;; start file watcher, open browser when started
  (clerk/serve! {:browse? true :watch-paths ["dev" "src" "notebooks"]})


  ;; do live coding



































  (do ;; start with file watcher only on notebooks
    (reset! nextjournal.clerk.webserver/!doc nextjournal.clerk.webserver/help-doc)
    (clerk/serve! {:browse? true :watch-paths ["notebooks"]}))




  (clerk/show! "notebooks/tap.clj")



  (clerk/show! "notebooks/rule_30.clj")



  (clerk/show! "notebooks/dice.clj")

















  ;; produce a static app
  (clerk/build-static-app! {:paths ["notebooks/thanks.clj"
                                    "notebooks/semantic.clj"
                                    "notebooks/how_clerk_works.clj"]})

  (clojure.java.browse/browse-url "https://app.netlify.com/drop/")
  (clojure.java.browse/browse-url "public")

  ;; produce a static app
  (clerk/build-static-app! {:paths (mapv #(str "notebooks/" % ".clj")
                                         '[introduction data_science rule_30 semantic])})

  )
