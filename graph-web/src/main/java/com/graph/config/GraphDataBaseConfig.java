//package com.graph.config;
//
//import com.example.jpa.entity.ExampleUser;
//import com.example.jpa.repository.ExampleUserRepository;
//import org.neo4j.driver.v1.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//
///**
// * Created by Administrator on 2017/9/27.
// */
//@Configuration
//@ComponentScan({"com.example.jpa.repository", "com.graph.config"})
//public class GraphDataBaseConfig {
//
//    public static Driver neoDriver = null;
//
//    @Autowired
//    ConfigUtil configUtil;
//
//    @Autowired
//    ExampleUserRepository exampleUserRepository;
//
//    /**
//     * 配置图数据库连接驱动
//     *
//     * @return
//     */
//    @Bean
//    public synchronized Driver initDataBaseDriver() throws MalformedURLException {
//        List<ExampleUser> all = exampleUserRepository.findAll();
//        String url = configUtil.getNeo4jUri();
//        String auth = new URL(url.replace("bolt", "http")).getUserInfo();
//        if (auth != null) {
//            String[] parts = auth.split(":");
//            String username = parts[0];
//            String password = parts[1];
//            boolean hasPassword = password != null && !password.isEmpty();
//            AuthToken token = hasPassword ? AuthTokens.basic(username, password) : AuthTokens.none();
//            Driver driver = GraphDatabase.driver(url, token, Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE)
//                    .toConfig());
//            if (neoDriver != null) {
//                neoDriver.close();
//            }
//            neoDriver = driver;
//        }
//        return neoDriver;
//    }
//
//    /**
//     * 获取session
//     *
//     * @return
//     */
//    public Session getSession() {
//        if (neoDriver != null) {
//            return neoDriver.session();
//        }
//        return null;
//    }
//}
