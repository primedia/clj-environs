(defproject environs "1.1.1"
  :description "Retrive System Property values loaded from the project .env file by com.rentpath.dotenv.core/dotenv!"
  :url "https://github.com/primedia/clj-environs"
  :license {:name "MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[ org.clojure/clojure "1.5.1" ]]

  :profiles
  {:test {:dependencies [[ com.rentpath/dotenv "1.0.3" ]]}}
                        
  ;;:repositories {"project" "file:repo"})
  :repositories [["iws_pair" "http://ec2-54-224-24-95.compute-1.amazonaws.com/maven/.m2"]])
