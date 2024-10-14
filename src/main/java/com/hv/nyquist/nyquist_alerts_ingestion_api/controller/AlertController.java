package com.hv.nyquist.nyquist_alerts_ingestion_api.controller;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import com.hv.nyquist.nyquist_alerts_ingestion_api.service.AlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jyoti
 */
@RestController
public class AlertController {
    @Autowired
    AlertService alertService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

    @PostMapping("/newrelic/alert")
    public ResponseEntity<String> receiveNewRelicAlert(@RequestBody AlertNotification alertNotification) {

        LOGGER.info("alert notification received: " + alertNotification);
        try {
            alertService.processAlertNotification(alertNotification);
            return ResponseEntity.ok("Alert notification from new relic processed successfully");
        } catch (Exception e) {
            LOGGER.error("Error processing alert notification from new relic", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process the Alert notification from new relic");
        }
    }

    @PostMapping("/newrelic/alertString")
    public void receiveNewRelicAlertString(@RequestBody String alertNotification) {

        LOGGER.info("alert notification received: " + alertNotification);

    }

}
