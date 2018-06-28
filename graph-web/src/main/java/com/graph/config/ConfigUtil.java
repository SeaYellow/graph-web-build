//package com.graph.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
///**
// * Created by Administrator on 2017/4/4.
// */
//@Configuration
//@ConfigurationProperties(prefix = "c")
//@PropertySource("classpath:config/config.properties")
//public class ConfigUtil {
//    private String differenceAnalysisUrl;
//    private String driver;
//    private String neo4jUri;
//    private String connectionPoolSize;
//    private String similarityDegree;
//
//    public String getDifferenceAnalysisUrl() {
//        return differenceAnalysisUrl;
//    }
//
//    public void setDifferenceAnalysisUrl(String differenceAnalysisUrl) {
//        this.differenceAnalysisUrl = differenceAnalysisUrl;
//    }
//
//    public String getDriver() {
//        return driver;
//    }
//
//    public void setDriver(String driver) {
//        this.driver = driver;
//    }
//
//    public String getNeo4jUri() {
//        return neo4jUri;
//    }
//
//    public void setNeo4jUri(String neo4jUri) {
//        this.neo4jUri = neo4jUri;
//    }
//
//    public String getConnectionPoolSize() {
//        return connectionPoolSize;
//    }
//
//    public void setConnectionPoolSize(String connectionPoolSize) {
//        this.connectionPoolSize = connectionPoolSize;
//    }
//
//    public double getSimilarityDegree() {
//        return Double.parseDouble(similarityDegree);
//    }
//
//    public void setSimilarityDegree(String similarityDegree) {
//        this.similarityDegree = similarityDegree;
//    }
//}
