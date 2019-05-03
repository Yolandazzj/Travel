package com.qdu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HotelController {
    @RequestMapping("/toHotel")
    public String toLogin() {
        return "userHotel";
    }
}
