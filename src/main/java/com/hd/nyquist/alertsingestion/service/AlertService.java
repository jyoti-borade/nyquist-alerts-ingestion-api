package com.hd.nyquist.alertsingestion.service;

import com.hd.nyquist.alertsingestion.dto.AlertNotification;

/**
 * @author Jyoti
 */
public interface AlertService {
    void processAlertNotification(AlertNotification alertNotification) throws Exception;
}
