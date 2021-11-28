^{:nextjournal.clerk/visibility #{:hide-ns}}
(ns python
  (:require [libpython-clj2.require :refer [require-python]]
            [libpython-clj2.python :refer [py. py.. py.-] :as py]
            [tech.v3.datatype :as dtype]
            [nextjournal.clerk :as clerk]))

(py/initialize! :python-executable "/home/dave/anaconda3/envs/fermi/bin/python3.7"
                :library-path "/home/dave/anaconda3/envs/fermi/lib/libpython3.7m.so")

(require-python '[numpy :as np])
(py/from-import scipy.stats ncx2)

(def test-ary (np/array [[1 2] [3 4]]))

(def res (py. ncx2 ppf (- 0.99 0.000001) 5.0 3.0))

res