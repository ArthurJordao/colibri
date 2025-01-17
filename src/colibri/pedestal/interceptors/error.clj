(ns colibri.pedestal.interceptors.error
  (:require [io.pedestal.log :as log]
            [io.pedestal.interceptor.chain :as chain]
            [io.pedestal.http :as http]))

(defn terminate-response [status message context]
  (chain/terminate (-> (assoc context :response {:status status
                                                 :body   {:error message}})
                       ((:leave http/json-body)))))

(def catch!
  {:name  ::catch
   :error (fn [context error]
            (log/error
              :log :response-error
              :exception (or (:cause (ex-data error)) error))
            (let [{:keys [type code message]} (ex-data error)]
              (if (and type code)
                (terminate-response code message context)
                (terminate-response 500 "ServerError" context))))})
