package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.pojo.Route;
import com.qdu.pojo.Scene;
import com.qdu.service.*;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private MessageService messageService;

    @Autowired
    private SceneService sceneService;
    @Autowired
    private SearchService searchService;

    @RequestMapping({"/index", "/"})
    public String index(Model model) {

        List sceneList=sceneService.sceneList();
        model.addAttribute("sceneList",sceneList);
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


//获取全部留言，分页
       @RequestMapping("user/message")
        public String message(Model model, HttpServletRequest request){
           try {
               String pageNo = request.getParameter("pageNo");
               if (pageNo == null) {
                   pageNo = "1";
               }
               page page = messageService.queryForPage(Integer.valueOf(pageNo), 8);
               model.addAttribute("page", page);
               List messageAll = page.getList();
               model.addAttribute("messageAll", messageAll);
           } catch (Exception e) {
               e.printStackTrace();
           }
            return "userMessage";
           }

           //模糊搜索所有
           @RequestMapping("user/searchAll")
    public String searchAll(Model model,HttpServletRequest request,String keyword){
               model.addAttribute("keyword", keyword);
               model.addAttribute("searchListByEssay",searchService.searchEssay(keyword));
               try {
                   String pageNo = request.getParameter("pageNo");
                   if (pageNo == null) {
                       pageNo = "1";
                   }
                   page page = searchService.queryForPage(Integer.valueOf(pageNo), 8,keyword);
                   model.addAttribute("page", page);
                   List searchListByRoute = page.getList();
               model.addAttribute("searchListByRoute",searchListByRoute);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               model.addAttribute("searchListByHotel",searchService.searchHotel(keyword));
        return "userSearch";
           }


}