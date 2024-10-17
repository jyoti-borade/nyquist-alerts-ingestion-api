package com.hd.nyquist.alertsingestion.service.impl;

import com.hd.nyquist.alertsingestion.controller.AlertController;
import com.hd.nyquist.alertsingestion.dto.AlertNotification;
import com.hd.nyquist.alertsingestion.service.AlertService;
import com.hd.nyquist.alertsingestion.service.ElasticsearchService;
import com.hd.nyquist.alertsingestion.utility.AlertMapper;
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
        elasticsearchService.insertData(altaAlertIndexName, alertNotification.getId(), jsonData);
        LOGGER.info("Alert data inserted successfully in index : " + altaAlertIndexName);
    }
}
