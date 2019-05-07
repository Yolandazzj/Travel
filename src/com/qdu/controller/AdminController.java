package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.service.FoodService;
import com.qdu.service.GroupService;
import com.qdu.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private SceneService sceneService;

    //管理员首页-组团游
    @RequestMapping("admin/group")
    public String adminGroup(Model model, HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = groupService.queryForPage(Integer.valueOf(pageNo),8);
            model.addAttribute("page",page);
            List groupAdminAll = page.getList();
            model.addAttribute("groupAdminAll", groupAdminAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminGroup";
    }

    //管理员首页-美食
    @RequestMapping("admin/food")
    public String adminFood(Model model,HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = foodService.queryForPage(Integer.valueOf(pageNo),8);
            model.addAttribute("page",page);
            List foodAdminAll = page.getList();
            model.addAttribute("foodAdminAll", foodAdminAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminFood";
    }

    //管理员首页-景点
    @RequestMapping("admin/scene")
    public String adminScene(Model model,HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = sceneService.queryForPage(Integer.valueOf(pageNo),8);
            model.addAttribute("page",page);
            List sceneAdminAll = page.getList();
            model.addAttribute("sceneAdminAll", sceneAdminAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminScene";
    }
}
