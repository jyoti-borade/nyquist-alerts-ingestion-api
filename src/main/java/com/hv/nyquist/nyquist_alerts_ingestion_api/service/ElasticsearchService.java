package com.hv.nyquist.nyquist_alerts_ingestion_api.service;

import com.hv.nyquist.nyquist_alerts_ingestion_api.entity.AltaAlert;

/**
 * @author Jyoti
 */
public interface ElasticsearchService {
    void insertData(String index, AltaAlert altaAlert) throws Exception;
}
