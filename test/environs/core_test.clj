(ns environs.core-test
  (:require [clojure.test :refer :all]
            [com.rentpath.dotenv.core :as dotenv :refer :all]
            [com.rentpath.environs.core :as environs :refer :all]))

(defn environ-fixture
  [f]
  (let [environ (load-env)
        previous-environ (zipmap (keys environ) (map #(System/getProperty %) (keys environ)))]
    ;; Set System Properties from .env.test and .env.local files
    (dotenv!)
    (f)
    ;; Reset environment
    (doseq [[k v] previous-environ] (set-property! k v))))

(use-fixtures :each environ-fixture)

(deftest test-10
  (testing "environs, should pass"
  (try
    (def result (Env "DOTENV_TEST_VAL_10"))
    (is (= result "http://localhost:3000"))
    (catch Exception e (str "caught exception: " (.getMessage e))))))
