package com.datasource.graph;

import com.datasource.graph.config.GraphDataBaseConfig;
import org.neo4j.driver.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/9/27.
 */
@Component
public class GraphDataBaseDriver {

    public static Driver neoDriver = null;

    @Autowired
    GraphDataBaseConfig graphDataBaseConfig;

    /**
     * 配置图数据库连接驱动
     *
     * @return
     */
    public Driver initDataBaseDriver() throws MalformedURLException {
        String url = graphDataBaseConfig.getNeo4jUri();
        String auth = new URL(url.replace("bolt", "http")).getUserInfo();
        if (auth != null) {
            String[] parts = auth.split(":");
            String username = parts[0];
            String password = parts[1];
            boolean hasPassword = password != null && !password.isEmpty();
            AuthToken token = hasPassword ? AuthTokens.basic(username, password) : AuthTokens.none();
            Driver driver = GraphDatabase.driver(url, token, Config.build().withEncryption().toConfig());
            if (neoDriver != null) {
                neoDriver.close();
            }
            neoDriver = driver;
        }
        return neoDriver;
    }

    /**
     * 获取session
     *
     * @return
     */
    public Session getSession() {
        if (neoDriver != null) {
            return neoDriver.session();
        }
        return null;
    }
}
