package com.datasource.graph.autoconfigure;

import com.datasource.graph.GraphDataBaseDriver;
import com.datasource.graph.config.GraphDataBaseConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by merit on 2018/2/8.
 */
@Configuration
@EnableConfigurationProperties(GraphDataBaseConfig.class)
public class GraphDataBaseAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(GraphDataBaseDriver.class)
    @ConditionalOnProperty(prefix = "graphWeb", value = {"driver", "neo4jUri", "connectionPoolSize"})
    public GraphDataBaseDriver graphDataBaseDriver() {
        return new GraphDataBaseDriver();
    }
}
