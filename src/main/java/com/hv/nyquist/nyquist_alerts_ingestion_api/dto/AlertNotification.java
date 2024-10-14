package com.hv.nyquist.nyquist_alerts_ingestion_api.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Jyoti
 */
@Data
@ToString
public class AlertNotification {
    private String id;
    private String issueUrl;
    private String title;
    private List<String> description;
    private String priority;
    private List<String> impactedEntities;
    private int totalIncidents;
    private String state;
    private String eventState;
    private String trigger;
    private boolean isCorrelated;
    private long createdAt;
    private long updatedAt;
    private List<String> sources;
    private List<String> alertPolicyNames;
    private List<String> alertConditionNames;
    private String workflowName;
    private List<String> clusterName;
    private List<String> deploymentName;
    private List<String> namespaceName;
    private List<String> appName;
    private List<String> containerName;
    private List<String> podName;
    private List<String> hostname;
    private String status;
    private List<String> metricName;
    private List<String> metricValue;
}
