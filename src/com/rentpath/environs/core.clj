(ns ^{:author "Jack Morrill"
     :doc "Retrieve JVM System Properties that were loaded from the project .env<.environment> file by clj-dotenv.

     Arguments:

       environment-value-name           string
       :allow-nil                       default false

     "}
     com.rentpath.environs.core
     (:require [clojure.string :as str]))

(defn- throw-ex [var]
  (throw (ex-info (str "Missing Environment Variable definition for " var) {:var var})))

(defn env
  "Retrive System Property value.
   If System Property is not found, attempt to retrieve the Environment Variable with the same name.
   If both lookups fail, throw an exception or return nil depending on the optional value of allow-nil
  "
  [env-name, & {:keys [allow-nil], :or {allow-nil false}}]
  (let [env-val (or (System/getProperty env-name) (System/getenv env-name))]
    (cond
     (nil?       env-val) (if allow-nil nil (throw-ex env-name))
     (str/blank? env-val) (if allow-nil ""  (throw-ex env-name))
     :otherwise           env-val)))
