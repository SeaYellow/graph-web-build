package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by merit on 2018/2/7.
 */
@Controller
@RequestMapping("example")
public class ExampleController {

//    @RequiresRoles("ADMIN")
    @RequestMapping("/goDie")
    public String goDie() {
        return "index";
    }
}
