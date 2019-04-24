package com.qdu.controller;

import com.qdu.pojo.Route;
import com.qdu.pojo.Scene;
import com.qdu.service.RouteService;
import com.qdu.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private RouteService routeService;

    @Autowired
    private SceneService sceneService;

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

//首页景点
    @RequestMapping("user/scene")
    public String scene(Model model) {

        Scene scene1=sceneService.hotScene1();
        Scene scene2=sceneService.hotScene2();
        Scene scene3=sceneService.hotScene3();
        Scene scene4=sceneService.hotScene4();
        Scene scene5=sceneService.hotScene5();
        Scene scene6=sceneService.hotScene6();
        Scene scene7=sceneService.hotScene7();
        model.addAttribute("scene1",scene1);
        model.addAttribute("scene2",scene2);
        model.addAttribute("scene3",scene3);
        model.addAttribute("scene4",scene4);
        model.addAttribute("scene5",scene5);
        model.addAttribute("scene6",scene6);
        model.addAttribute("scene7",scene7);
        return "userScene";
}

}