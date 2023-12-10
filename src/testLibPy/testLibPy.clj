(ns testLibPy.testLibPy
  (:require [libpython-clj2.python :as py]))

(py/initialize!)

(comment
  (require '[nextjournal.clerk :as clerk])
  (require '[nextjournal.clerk.viewer :as v])

  (clerk/serve! {:browse? false})
  (clerk/show! "src/testLibPy/testLibPy.clj")
  (clerk/clear-cache!))

(def datasets-module (py/import-module "sklearn.datasets"))

;;rendering
(def newsgroups
  (->
   (py/py. datasets-module fetch_20newsgroups)
   py/->jvm))

;;not rendering (well)
(def newsgroups-2
  (py/py. datasets-module fetch_20newsgroups))


