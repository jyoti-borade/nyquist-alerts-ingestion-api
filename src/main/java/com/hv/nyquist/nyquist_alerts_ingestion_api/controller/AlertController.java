package com.hv.nyquist.nyquist_alerts_ingestion_api.controller;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import com.hv.nyquist.nyquist_alerts_ingestion_api.service.AlertService;
import com.hv.nyquist.nyquist_alerts_ingestion_api.utility.AlertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {

    @Autowired
  //  @Qualifier("NewRelicAlertService")
    AlertService alertService;

    @PostMapping("/newrelic/alert")
    public ResponseEntity<String> receiveNewRelicAlert(@RequestBody AlertNotification alertNotification) {

        System.out.println(" alertNotification: " + alertNotification);

        alertService.processAlertNotification(alertNotification);
        // Return a response to New Relic
        return ResponseEntity.ok("Alert processed successfully");
    }
}
