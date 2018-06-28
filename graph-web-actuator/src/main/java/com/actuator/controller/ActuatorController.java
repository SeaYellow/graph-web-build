package com.actuator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by merit on 2018/2/5.
 */
@Controller
@RequestMapping("actuator")
public class ActuatorController {

    @RequestMapping("/navigate")
    public String navigate() {
        return "navigate";
    }
}
