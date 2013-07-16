(ns ^{:author "Jack Morrill"
     :doc "Retrieve JVM System Properties that were loaded from the project .env file by dotenv."}
     environs.core
     (:require [clojure.string :as string]))

(defn get-env
  "Retrive System Property value.
   If System Property is not found, attempt retrieve the Environment Variable withthe same neme.
   If both lookup fail, throw an exception"
  [env-name]
  (let [env-val (or (System/getProperty env-name) (System/getenv env-name))]
    (if (string/blank? env-val)
      (throw (Exception. "MissingEnvVarError"))
      env-val)))

