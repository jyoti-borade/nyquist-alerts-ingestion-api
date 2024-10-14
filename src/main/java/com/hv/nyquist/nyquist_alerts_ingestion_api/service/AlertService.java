package com.hv.nyquist.nyquist_alerts_ingestion_api.service;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;

/**
 * @author Jyoti
 */
public interface AlertService {
    void processAlertNotification(AlertNotification alertNotification) throws Exception;
}
