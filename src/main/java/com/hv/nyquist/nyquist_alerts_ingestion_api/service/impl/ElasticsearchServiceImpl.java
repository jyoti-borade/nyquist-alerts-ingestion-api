package com.hv.nyquist.nyquist_alerts_ingestion_api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hv.nyquist.nyquist_alerts_ingestion_api.service.ElasticsearchService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author Jyoti
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchServiceImpl.class);
    private final RestHighLevelClient restHighLevelClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public ElasticsearchServiceImpl(RestHighLevelClient restHighLevelClient, ObjectMapper objectMapper) {
        this.restHighLevelClient = restHighLevelClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public void insertData(String index, Map<String, Object> jsonData) throws IOException {
        try {
            //   Map<String, Object> dataMap = objectMapper.convertValue(jsonData, Map.class);

            IndexRequest request = new IndexRequest(index).source(jsonData);

            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);

            LOGGER.info("Document indexed with ID: {}", response.getId());

        } catch (IOException e) {
            LOGGER.error("Error occurred while indexing document in Elasticsearch: {}", e.getMessage());
            throw e;
        }
    }
}
