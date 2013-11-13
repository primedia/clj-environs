(ns environs.core-test
  (:require [clojure.test :refer :all]
            [dotenv.core :as dotenv :refer :all]
            [environs.core :as environs :refer :all]))

(deftest test-10
  (testing "dotenv, should pass"
  (load-env)
  (try
    (def result (Env "DOTENV_TEST_VAL_10"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))
