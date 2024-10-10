package com.hv.nyquist.nyquist_alerts_ingestion_api.controller;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertController {
    @PostMapping("/newrelic/alert")
    public ResponseEntity<String> receiveNewRelicAlert(@RequestBody AlertNotification alertNotification) {

        System.out.println(alertNotification.toString());

        // Return a response to New Relic
        return ResponseEntity.ok("Alert processed successfully");
    }
}
