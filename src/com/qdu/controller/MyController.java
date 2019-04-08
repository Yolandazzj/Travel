package com.qdu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
@Controller
public class MyController {

    @RequestMapping({"/index", "/"})
    public String index() {
        return "index";
    }
}
