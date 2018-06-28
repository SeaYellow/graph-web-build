package com.example.controller.child;

import com.alibaba.fastjson.JSONObject;
import com.example.jdbc.ExampleJdbcService;
import com.example.jpa.entity.ExampleUser;
import com.example.jpa.repository.ExampleUserRepository;
import com.example.service.IExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by merit on 2018/2/7.
 */
@RestController
@RequestMapping("example")
public class ExampleRestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    IExampleService iExampleService;

    @Autowired
    ExampleUserRepository repository;

    @Autowired
    ExampleJdbcService exampleJdbcService;

    @RequestMapping("/addExampleNode")
    public JSONObject addNode() {
        return iExampleService.addNode();
    }

    @RequestMapping("/queryNodesByLabel/{label}")
    public JSONObject queryNodesByLabel(@PathVariable("label") String label) {
        logger.info("label : " + label);
        return iExampleService.queryNodesByLabel(label);
    }

    @RequestMapping("/queryExampleUserByName/{userName}")
    public ExampleUser queryExampleUserByName(@PathVariable("userName") String userName) {
        logger.info("userName : " + userName);
        return repository.findByUserName(userName);
    }

    @RequestMapping("/queryExampleUserByNameFromJdbc/{userName}")
    public List<ExampleUser> queryExampleUserByNameFromJdbc(@PathVariable("userName") String userName) {
        logger.info("userName : " + userName);
        return exampleJdbcService.findExampleUserByName(userName);
    }


}
