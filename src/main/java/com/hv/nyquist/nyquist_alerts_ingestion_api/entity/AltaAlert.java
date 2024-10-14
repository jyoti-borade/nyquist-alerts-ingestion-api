package com.hv.nyquist.nyquist_alerts_ingestion_api.entity;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Map;

/**
 * @author Jyoti
 */
@Data
@ToString
public class AltaAlert {
    private Long label;
    private String alertRules;
    private String alertType;
    private Long anomaly;
    private String anomalyType;
    private String caseId;
    private String categoryKey;
    private String categoryType;
    private String ciName;
    private String ciType;
    private String cluster;
    private String cmdbApplication;
    private String cmdbApplicationCount;
    private String cmdbHostname;
    private String cmdbId;
    private String cmdbIp;
    private String cmdbPoolCount;
    private String cmdbRaidpool;
    private String comments;
    private String condition;
    private String containerName;
    private Long createdTime;
    private String daemonsetName;
    private String deployment;
    private String description;
    private String destinationApp;
    private String eventId;
    private String eventIds;
    private String eventState;
    private String eventType;
    private Boolean falsePositive;
    private String falsePositiveComments;
    private Boolean gaugeAnomalyEligible;
    private Timestamp generatedTime;
    private String host;
    private String id;
    private String incidentId;
    private String labelStatus;
    private Map<String, Object> labels;
    private Long lastUpdatedTime;
    private String metricDescription;
    private String metricType;
    private String namespace;
    private String nodeDatacenter;
    private String nodeEnvironment;
    private String nodeFqdn;
    private String nodeId;
    private String nodeIp;
    private String nodeType;
    private String partitionKey;
    private String phase;
    private String pod;
    private String priority;
    private String reason;
    private Timestamp receivedTime;
    private String region;
    private String reporter;
    private String resource;
    private String resourceGroup;
    private String responseCode;
    private Boolean ruleBasedAlert;
    private String service;
    private String severity;
    private String situationId;
    private String sourceApp;
    private String sourceId;
    private String sourceName;
    private String sourceNodeDatacenter;
    private String sourceNodeFqdn;
    private String sourceNodeId;
    private String sourceNodeIp;
    private String sourceNodeType;
    private String statefulsetName;
    private String status;
    private Boolean sumAnomalyEligible;
    private String tags;
    private String tenantId;
    private Double thresholdValue;
    private Timestamp timeDay;
    private Timestamp timeHalf;
    private Timestamp timeHour;
    private Timestamp timeQuarter;
    private Timestamp timeWeek;
    private String title;
    private String topTalkers;
    private String traceId;
    private Double triggeredValue;
    private String user;
    private String userDiagnosis;
    private String uuid;
    private String value;
}
