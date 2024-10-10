package com.hv.nyquist.nyquist_alerts_ingestion_api.service.impl;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import com.hv.nyquist.nyquist_alerts_ingestion_api.entity.AltaAlert;
import com.hv.nyquist.nyquist_alerts_ingestion_api.service.AlertService;
import com.hv.nyquist.nyquist_alerts_ingestion_api.utility.AlertMapper;
import org.springframework.stereotype.Service;

@Service
public class NewRelicAlertService implements AlertService {
    @Override
    public void processAlertNotification(AlertNotification alertNotification) {
      AltaAlert altaAlert = AlertMapper.mapToAltaAlert(alertNotification);
      System.out.println(" altaAlert: " + altaAlert);
    }
}
