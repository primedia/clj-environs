(ns ^{:author "Jack Morrill"
     :doc "Retrieve JVM System Properties that were loaded from the project .env<.environment> file by clj-dotenv.

     TODO

     The environs function is supposed to take an optional parameter that tells environs to return nil instead of throwing an Exception

     "}

     environs.core
     (:require [clojure.string :as string]))

(defn get-env
  "Retrive System Property value.
   If System Property is not found, attempt to retrieve the Environment Variable with the same neme.
   If both lookup fail, throw an exception"
  [env-name]
  (let [env-val (or (System/getProperty env-name) (System/getenv env-name))]
    (if (string/blank? env-val)
      (throw (Exception. (str "Missing Environment Variable definition for " env-name)))
      env-val)))

