(ns environs.core-test
  (:require [clojure.test :refer :all]
            [com.rentpath.dotenv.core :refer [load-env dotenv! set-property!]]
            [com.rentpath.environs.core :refer [env]]))

(defn environ-fixture
  [f]
  (let [environ (load-env)
        previous-environ (zipmap (keys environ) (map #(System/getProperty %) (keys environ)))]
    ;; Set System Properties from .env.<environment> and .env.local files
    (dotenv!)
    (f)
    ;; Reset environment
    (doseq [[k v] previous-environ] (set-property! k v))))

(use-fixtures :each environ-fixture)

(deftest test-allow-nil

  (testing "var is found"
    (testing "var value is nil"
      (testing "blows up when allow-nil is false"
        (is (= :BOOM
               (try (env "ENV_TEST_NIL")
                    (catch Exception e :BOOM)))))

      (testing "returns nil when allow-nil is true"
        (is (= nil (env "ENV_TEST_NIL" :allow-nil true)))))

    (testing "var value is the empty-string"
      (testing "blows up when allow-nil is false"
        (is (= :BOOM
               (try (env "ENV_TEST_EMPTY_STRING")
                    (catch Exception e :BOOM)))))

      (testing "returns empty-string when allow-nil is true"
        (is (= "" (env "ENV_TEST_EMPTY_STRING" :allow-nil true)))))


    (testing "var value is a normal string"
      (testing "returns value when allow-nil is false"
        (is (= "foobar" (env "ENV_TEST_STRING"))))

      (testing "returns value when allow-nil is true"
        (is (= "foobar" (env "ENV_TEST_STRING" :allow-nil true))))))


  (testing "env var is not found"
    (testing "blow up when allow-nil is false"
      (is (= :BOOM
             (try (env "DOES_NOT_EXIST")
                  (catch Exception e :BOOM)))))

    (testing "return nil when allow-nil is true"
      (is (= nil (env "DOES_NOT_EXIST" :allow-nil true))))))
