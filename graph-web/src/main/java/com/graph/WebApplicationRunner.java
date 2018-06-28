//package com.graph;
//
//import com.datasource.graph.GraphDataBaseDriver;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
///**
// * Created by merit on 2018/2/8.
// */
//@Component
//public class WebApplicationRunner implements ApplicationRunner {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//    @Autowired
//    GraphDataBaseDriver graphDataBaseDriver;
//
//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        logger.info("Start init graph database.");
//        graphDataBaseDriver.initDataBaseDriver();
//        logger.info("End init graph database.");
//    }
//}
