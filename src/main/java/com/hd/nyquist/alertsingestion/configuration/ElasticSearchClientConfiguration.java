package com.hd.nyquist.alertsingestion.configuration;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Jyoti
 */
@Configuration
public class ElasticSearchClientConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.username}")
    private String username;

    @Value("${elasticsearch.password}")
    private String password;

    @Value("${elasticsearch.ssl.enabled}")
    private boolean sslEnabled;

    // This method configures and returns a RestHighLevelClient bean
    @Bean
    public RestHighLevelClient esclient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, sslEnabled ? "https" : "http"));

        // Optional: Add basic authentication if username/password is provided
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            final BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));

            builder.setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setDefaultIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(Runtime.getRuntime().availableProcessors()).build()));
        }

        // Return the RestHighLevelClient
        return new RestHighLevelClient(builder);
    }

    // Method to close the client
    public void closeClient(RestHighLevelClient client) throws IOException {
        if (client != null) {
            client.close();
        }
    }
}
