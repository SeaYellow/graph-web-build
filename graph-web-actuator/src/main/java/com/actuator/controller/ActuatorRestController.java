package com.actuator.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by merit on 2018/2/5.
 */
@RestController
@RequestMapping("actuator")
public class ActuatorRestController {

    @RequestMapping("/getActuatorMsg")
    public JSONObject getActuatorMsg() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("message", "Hello Actuator User.");
        return jsonObject;
    }
}
