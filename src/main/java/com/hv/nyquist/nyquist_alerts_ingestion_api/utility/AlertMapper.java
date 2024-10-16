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

        jsonData.put("ci_name", (alertNotification.getMetricNames() != null && !alertNotification.getMetricNames().isEmpty()) ? alertNotification.getMetricNames().get(0) : null);

        // jsonData.put("ci_type", metric_unit);
        jsonData.put("title", alertNotification.getTitle());

        jsonData.put("value", (alertNotification.getMetricValues() != null && !alertNotification.getMetricValues().isEmpty()) ? alertNotification.getMetricValues().get(0) : null);

        //  jsonData.put("user", alertNotification.getUser());

        jsonData.put("tags", null);

        jsonData.put("severity", alertNotification.getPriority());
        jsonData.put("priority", alertNotification.getPriority());

        jsonData.put("description", (alertNotification.getDescriptions() != null && !alertNotification.getDescriptions().isEmpty()) ? alertNotification.getDescriptions().get(0) : null);

        jsonData.put("event_state", alertNotification.getState());

        jsonData.put("category_type", "NewRelicAlert");

        String unqKey = ((alertNotification.getContainerNames() != null && !alertNotification.getContainerNames().isEmpty()) ? alertNotification.getContainerNames().get(0) : "") + "_" + ((alertNotification.getPodNames() != null && !alertNotification.getPodNames().isEmpty()) ? alertNotification.getPodNames().get(0) : "") + "_" + ((alertNotification.getHostnames() != null && !alertNotification.getNodeNames().isEmpty()) ? alertNotification.getNodeNames().get(0) : "") + "_" + ((alertNotification.getNodeNames() != null && !alertNotification.getNamespaceNames().isEmpty()) ? alertNotification.getNamespaceNames().get(0) : "") + "_" + ((alertNotification.getClusterNames() != null && !alertNotification.getClusterNames().isEmpty()) ? alertNotification.getClusterNames().get(0) : "") + "_" + tenantId;

        jsonData.put("category_key", unqKey);

        //  jsonData.put("threshold_value", value_at_threshold);

        // jsonData.put("triggered_value", (alertNotification.getMetricValue() != null && !alertNotification.getMetricValue().isEmpty()) ? alertNotification.getMetricValue().get(0) : null);

        jsonData.put("false_positive", null);
        jsonData.put("comments", null);
        jsonData.put("false_positive_comments", null);

        // jsonData.put("status", alertNotification.getStatus());
        jsonData.put("status", "New");

        jsonData.put("cluster", (alertNotification.getClusterNames() != null && !alertNotification.getClusterNames().isEmpty()) ? alertNotification.getClusterNames().get(0) : null);

        jsonData.put("namespace", (alertNotification.getNamespaceNames() != null && !alertNotification.getNamespaceNames().isEmpty()) ? alertNotification.getNamespaceNames().get(0) : null);

        jsonData.put("deployment", (alertNotification.getDeploymentNames() != null && !alertNotification.getDeploymentNames().isEmpty()) ? alertNotification.getDeploymentNames().get(0) : null);

        jsonData.put("service", (alertNotification.getImpactedEntities() != null && !alertNotification.getImpactedEntities().isEmpty()) ? alertNotification.getImpactedEntities().get(0) : null);

    //    jsonData.put("host", (alertNotification.getHostnames() != null && !alertNotification.getHostnames().isEmpty()) ? alertNotification.getHostnames().get(0) : null);

        jsonData.put("host", (alertNotification.getNodeNames() != null && !alertNotification.getNodeNames().isEmpty()) ? alertNotification.getNodeNames().get(0) : null);


        jsonData.put("pod", (alertNotification.getPodNames() != null && !alertNotification.getPodNames().isEmpty()) ? alertNotification.getPodNames().get(0) : null);

        //  jsonData.put("statefulsetName", alertNotification.getStatefulsetName()); 
        //  jsonData.put("daemonsetName", alertNotification.getDaemonsetName()); 

        jsonData.put("containerName", (alertNotification.getContainerNames() != null && !alertNotification.getContainerNames().isEmpty()) ? alertNotification.getContainerNames().get(0) : null);

        jsonData.put("metricDescription", (alertNotification.getDescriptions() != null && !alertNotification.getDescriptions().isEmpty()) ? alertNotification.getDescriptions().get(0) : null);

        //  jsonData.put("metric_type", alertNotification.getMetric_type()); 
        //  jsonData.put("ukType", alertNotification.getUkType()); 
        //  jsonData.put("uuid", alertNotification.getUuid()); 

        return jsonData;
    }
}
