package com.hv.nyquist.nyquist_alerts_ingestion_api.utility;

import com.hv.nyquist.nyquist_alerts_ingestion_api.dto.AlertNotification;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jyoti
 */
@Component
public class AlertMapper {
    public static Map<String, Object> mapToAltaAlert(AlertNotification alertNotification) {
        Map<String, Object> jsonData = new HashMap<>();

        if (alertNotification == null) {
            throw new IllegalArgumentException("AlertNotification object cannot be null");
        }

        jsonData.put("id", alertNotification.getId());

        long generated_time = System.currentTimeMillis();
        jsonData.put("generated_time", generated_time);

        jsonData.put("received_time", alertNotification.getCreatedAt());

        jsonData.put("source_id", (alertNotification.getSources() != null && !alertNotification.getSources().isEmpty()) ? alertNotification.getSources().get(0) : null);

        jsonData.put("source_name", (alertNotification.getSources() != null && !alertNotification.getSources().isEmpty()) ? alertNotification.getSources().get(0) : null);

        jsonData.put("source_node_id", null);
        jsonData.put("source_node_ip", null);

        String tenantId = "opis";

        jsonData.put("tenant_id", tenantId);

        jsonData.put("source_node_fqdn", null);
        jsonData.put("source_node_datacenter", null);
        jsonData.put("source_node_type", null);

        jsonData.put("node_id", null);
        jsonData.put("node_ip", null);
        jsonData.put("node_fqdn", null);
        jsonData.put("node_datacenter", null);
        jsonData.put("node_type", null);
        jsonData.put("node_environment", null);
        jsonData.put("event_type", null);

        jsonData.put("resource", null);

        jsonData.put("ci_name", (alertNotification.getMetricName() != null && !alertNotification.getMetricName().isEmpty()) ? alertNotification.getMetricName().get(0) : null);

        // jsonData.put("ci_type", metric_unit);
        jsonData.put("title", alertNotification.getTitle());

        jsonData.put("value", (alertNotification.getMetricValue() != null && !alertNotification.getMetricValue().isEmpty()) ? alertNotification.getMetricValue().get(0) : null);

        //  jsonData.put("user", alertNotification.getUser());

        jsonData.put("tags", null);

        jsonData.put("severity", alertNotification.getPriority());
        jsonData.put("priority", alertNotification.getPriority());

        jsonData.put("description", (alertNotification.getDescription() != null && !alertNotification.getDescription().isEmpty()) ? alertNotification.getDescription().get(0) : null);

        jsonData.put("event_state", alertNotification.getState());

        jsonData.put("category_type", "NewRelicAlert");

        String unqKey = ((alertNotification.getContainerName() != null && !alertNotification.getContainerName().isEmpty()) ? alertNotification.getContainerName().get(0) : "") + "_" + ((alertNotification.getPodName() != null && !alertNotification.getPodName().isEmpty()) ? alertNotification.getPodName().get(0) : "") + "_" + ((alertNotification.getHostname() != null && !alertNotification.getHostname().isEmpty()) ? alertNotification.getHostname().get(0) : "") + "_" + ((alertNotification.getNamespaceName() != null && !alertNotification.getNamespaceName().isEmpty()) ? alertNotification.getNamespaceName().get(0) : "") + "_" + ((alertNotification.getClusterName() != null && !alertNotification.getClusterName().isEmpty()) ? alertNotification.getClusterName().get(0) : "") + "_" + tenantId;

        jsonData.put("category_key", unqKey);

        //  jsonData.put("threshold_value", value_at_threshold);

        // jsonData.put("triggered_value", (alertNotification.getMetricValue() != null && !alertNotification.getMetricValue().isEmpty()) ? alertNotification.getMetricValue().get(0) : null);

        jsonData.put("false_positive", null);
        jsonData.put("comments", null);
        jsonData.put("false_positive_comments", null);

        // jsonData.put("status", alertNotification.getStatus());
        jsonData.put("status", "New");

        jsonData.put("cluster", (alertNotification.getClusterName() != null && !alertNotification.getClusterName().isEmpty()) ? alertNotification.getClusterName().get(0) : null);

        jsonData.put("namespace", (alertNotification.getNamespaceName() != null && !alertNotification.getNamespaceName().isEmpty()) ? alertNotification.getNamespaceName().get(0) : null);

        jsonData.put("deployment", (alertNotification.getDeploymentName() != null && !alertNotification.getDeploymentName().isEmpty()) ? alertNotification.getDeploymentName().get(0) : null);

        jsonData.put("service", (alertNotification.getImpactedEntities() != null && !alertNotification.getImpactedEntities().isEmpty()) ? alertNotification.getImpactedEntities().get(0) : null);

        jsonData.put("host", (alertNotification.getHostname() != null && !alertNotification.getHostname().isEmpty()) ? alertNotification.getHostname().get(0) : null);

        jsonData.put("pod", (alertNotification.getPodName() != null && !alertNotification.getPodName().isEmpty()) ? alertNotification.getPodName().get(0) : null);

        //  jsonData.put("statefulsetName", alertNotification.getStatefulsetName()); 
        //  jsonData.put("daemonsetName", alertNotification.getDaemonsetName()); 

        jsonData.put("containerName", (alertNotification.getContainerName() != null && !alertNotification.getContainerName().isEmpty()) ? alertNotification.getContainerName().get(0) : null);

        jsonData.put("metricDescription", (alertNotification.getDescription() != null && !alertNotification.getDescription().isEmpty()) ? alertNotification.getDescription().get(0) : null);

        //  jsonData.put("metric_type", alertNotification.getMetric_type()); 
        //  jsonData.put("ukType", alertNotification.getUkType()); 
        //  jsonData.put("uuid", alertNotification.getUuid()); 

        return jsonData;
    }
}
