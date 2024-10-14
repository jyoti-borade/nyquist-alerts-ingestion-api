package com.hv.nyquist.nyquist_alerts_ingestion_api.utility;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import com.hv.nyquist.nyquist_alerts_ingestion_api.entity.AltaAlert;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * @author Jyoti
 */
@Component
public class AlertMapper {
    public static AltaAlert mapToAltaAlert(AlertNotification alertNotification) {
        AltaAlert altaAlert = new AltaAlert();

        altaAlert.setId(alertNotification.getId());

        altaAlert.setTitle(alertNotification.getTitle());
        altaAlert.setDescription(alertNotification.getTitle());

        altaAlert.setPriority(alertNotification.getPriority());

        altaAlert.setTags(String.join(", ", alertNotification.getImpactedEntities()));

        altaAlert.setComments("Total incidents: " + alertNotification.getTotalIncidents());

        altaAlert.setEventState(alertNotification.getState());

        altaAlert.setReason(alertNotification.getTrigger());
        altaAlert.setCondition(alertNotification.getTrigger());

        altaAlert.setFalsePositive(!alertNotification.isCorrelated());

        altaAlert.setCreatedTime(alertNotification.getCreatedAt());
        altaAlert.setLastUpdatedTime(alertNotification.getUpdatedAt());
        altaAlert.setGeneratedTime(new Timestamp(alertNotification.getCreatedAt()));
        altaAlert.setReceivedTime(new Timestamp(alertNotification.getUpdatedAt()));

        if (alertNotification.getSources() != null && !alertNotification.getSources().isEmpty()) {
            altaAlert.setSourceName(String.join(", ", alertNotification.getSources()));  // Multiple sources joined as a string
        }

        // Mapping alertPolicyNames (could map to alertRules or comments)
        if (alertNotification.getAlertPolicyNames() != null) {
            altaAlert.setAlertRules(String.join(", ", alertNotification.getAlertPolicyNames()));  // Mapping policies to alert rules
        }

        // Mapping alertConditionNames (could map to condition or comments)
        if (alertNotification.getAlertConditionNames() != null) {
            altaAlert.setCondition(String.join(", ", alertNotification.getAlertConditionNames()));  // Mapping conditions to condition field
        }

        // Mapping workflowName (custom field like categoryType or service)
        altaAlert.setCluster(alertNotification.getClusterName());
        altaAlert.setDeployment(alertNotification.getDeploymentName());
        altaAlert.setNamespace(alertNotification.getNamespaceName());
        altaAlert.setService(alertNotification.getAppName());

        return altaAlert;
    }

}
