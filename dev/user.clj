(ns user
  (:require [nextjournal.clerk :as clerk]))

(comment
  ;; start without file watcher, open browser when started
  (clerk/serve! {:browse? true})

  ;; start with file watcher for these sub-directory paths
  (clerk/serve! {:watch-paths ["notebooks" "src"]})

  ;; start with file watcher and a `show-filter-fn` function to watch
  ;; a subset of notebooks
  (clerk/serve! {:watch-paths ["notebooks" "src"] :show-filter-fn #(clojure.string/starts-with? % "notebooks")})

  (clerk/clear-cache!)

  ;; Run this form to see error:
  ; Execution error (AssertionError) at nextjournal.clerk.viewer/bounded-count-opts (viewer.cljc:308).
  ; Assert failed: n must be a number?
  ; (number? n)
  (clerk/show! "notebooks/python.clj")

  ;; or call `clerk/show!` explicitly
  (clerk/show! "notebooks/introduction.clj") ; TODO combine with "hello" and "pagination" to make a nice intro
  (clerk/show! "notebooks/pagination.clj")
  (clerk/show! "notebooks/viewer_api.clj") ; TODO expand or combine with intro?

  ;; done
  (clerk/show! "notebooks/data_science.clj")
  (clerk/show! "notebooks/sicmutils.clj")
  (clerk/show! "notebooks/rule_30.clj")
  (clerk/show! "notebooks/semantic.clj")

  ;; TODO If you would like more details about how Clerk works, here's a
  ;; notebook with some implementation details.
  (clerk/show! "notebooks/how_clerk_works.clj")

  ;; produce a static app
  (clerk/build-static-app! {:paths (mapv #(str "notebooks/" % ".clj")
                                         '[introduction data_science rule_30 semantic])})

  )
