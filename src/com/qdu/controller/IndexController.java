package com.qdu.controller;

import com.qdu.pojo.Route;
import com.qdu.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private RouteService routeService;

    @RequestMapping({"/index", "/"})
    public String index() {
        return "index";
    }


//首页跟团游
    @RequestMapping("user/tours")
    public String tours(Model model) {
      Route route1= routeService.hotRoute1();
        Route route2= routeService.hotRoute2();
        Route route3= routeService.hotRoute3();
        Route route4= routeService.hotRoute4();
        Route route5= routeService.hotRoute5();
        Route route6= routeService.hotRoute6();
        Route route7= routeService.hotRoute7();
        model.addAttribute("route1",route1);
        model.addAttribute("route2",route2);
        model.addAttribute("route3",route3);
        model.addAttribute("route4",route4);
        model.addAttribute("route5",route5);
        model.addAttribute("route6",route6);
        model.addAttribute("route7",route7);

        return "userRoute";
    }

}