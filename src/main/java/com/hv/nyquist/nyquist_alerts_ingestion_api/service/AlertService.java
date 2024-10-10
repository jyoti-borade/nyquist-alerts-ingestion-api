package com.hv.nyquist.nyquist_alerts_ingestion_api.service;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;

public interface AlertService {
    void processAlertNotification(AlertNotification alertNotification);
}
