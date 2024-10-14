package com.hv.nyquist.nyquist_alerts_ingestion_api.service.impl;

import com.hv.nyquist.nyquist_alerts_ingestion_api.controller.AlertController;
import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import com.hv.nyquist.nyquist_alerts_ingestion_api.service.AlertService;
import com.hv.nyquist.nyquist_alerts_ingestion_api.service.ElasticsearchService;
import com.hv.nyquist.nyquist_alerts_ingestion_api.utility.AlertMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Jyoti
 */
@Service
public class NewRelicAlertService implements AlertService {

    @Value("${elasticsearch.alta-alert.index-name}")
    private String altaAlertIndexName;

    @Autowired
    private ElasticsearchService elasticsearchService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

    @Override
    public void processAlertNotification(AlertNotification alertNotification) throws Exception {
        Map<String, Object> jsonData = AlertMapper.mapToAltaAlert(alertNotification);
        LOGGER.info("altaAlert json: " + jsonData);
        elasticsearchService.insertData(altaAlertIndexName, jsonData);
        LOGGER.info("Alert data inserted successfully in index : " + altaAlertIndexName);
    }
}
