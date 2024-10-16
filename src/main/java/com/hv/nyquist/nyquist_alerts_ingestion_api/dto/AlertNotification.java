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
    private List<String> descriptions;
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
    private List<String> clusterNames;
    private List<String> deploymentNames;
    private List<String> namespaceNames;
    private List<String> appNames;
    private List<String> containerNames;
    private List<String> podNames;
    private List<String> nodeNames;
    private List<String> hostnames;
    private String status;
    private List<String> metricNames;
    private List<String> metricValues;
}
