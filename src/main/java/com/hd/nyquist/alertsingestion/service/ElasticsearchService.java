package com.hd.nyquist.alertsingestion.service;

import java.util.Map;

/**
 * @author Jyoti
 */
public interface ElasticsearchService {
    void insertData(String index, String id, Map<String, Object> jsonData) throws Exception;
}
