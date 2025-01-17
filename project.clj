(defproject arthurjordao/colibri "0.0.1"
  :description "A tiny and composable library for creating Clojure web services"
  :license {:name         "MIT"
            :distribution :repo}
  :deploy-repositories [["releases" {:sign-releases false :url "https://clojars.org/repo"}]
                        ["snapshots" {:sign-releases false :url "https://clojars.org/repo"}]]
  :url "https://github.com.br/arthurjordao/colibri"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clojure.java-time "0.3.2"]
                 [aero "1.1.3"]
                 [prismatic/schema "1.3.0"]
                 [metosin/schema-tools "0.10.3"]
                 [buddy "2.0.0"]
                 [cheshire "5.8.0"]
                 [com.stuartsierra/component "1.1.0"]
                 [io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.service-tools "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [ch.qos.logback/logback-classic "1.1.8" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.22"]
                 [org.slf4j/jcl-over-slf4j "1.7.22"]
                 [org.slf4j/log4j-over-slf4j "1.7.22"]
                 [mvxcvi/puget "1.0.2"]]
  :min-lein-version "2.0.0"
  :profiles {:uberjar {:aot :all}
             :dev     {:injections [(require 'colibri.misc)
                                    (require 'colibri.time)]}})
