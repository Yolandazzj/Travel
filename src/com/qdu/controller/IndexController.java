package com.qdu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
@Controller
public class IndexController {

    @RequestMapping({"/index", "/"})
    public String index() {
        return "index";
    }


//首页跟团游
    @RequestMapping("user/tours")
    public String tours() {
        return "userRoute";
    }

}