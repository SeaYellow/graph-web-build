package com.datasource.graph.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2017/4/4.
 */
@ConfigurationProperties(prefix = "graphWeb")
//@PropertySource("classpath:config/config.properties")
public class GraphDataBaseConfig {
    private String driver;
    private String neo4jUri;
    private String connectionPoolSize;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getNeo4jUri() {
        return neo4jUri;
    }

    public void setNeo4jUri(String neo4jUri) {
        this.neo4jUri = neo4jUri;
    }

    public String getConnectionPoolSize() {
        return connectionPoolSize;
    }

    public void setConnectionPoolSize(String connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

}
