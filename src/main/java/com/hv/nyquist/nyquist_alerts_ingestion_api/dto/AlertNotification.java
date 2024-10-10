package com.hv.nyquist.nyquist_alerts_ingestion_api.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AlertNotification {
    private String id;
    private String issueUrl;
    private String title;
    private String priority;
    private List<String> impactedEntities;
    private int totalIncidents;
    private String state;
    private String trigger;
    private boolean isCorrelated;
    private long createdAt;
    private long updatedAt;
    private List<String> sources;
    private List<String> alertPolicyNames;
    private List<String> alertConditionNames;
    private String workflowName;
}
