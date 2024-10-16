package com.hv.nyquist.nyquist_alerts_ingestion_api.service;

import java.util.Map;

/**
 * @author Jyoti
 */
public interface ElasticsearchService {
    void insertData(String index, String id, Map<String, Object> jsonData) throws Exception;
}
