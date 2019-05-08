package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.service.AdminManageService;
import com.qdu.service.FoodService;
import com.qdu.service.GroupService;
import com.qdu.service.SceneService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private AdminManageService adminManageService;

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


    //管理员查看所有订单
    @RequestMapping("admin/orderAll")
    public String orderAll(HttpServletRequest request, Model model){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page orderPage =adminManageService .queryForPage(Integer.valueOf(pageNo), 3);
            model.addAttribute("orderPage", orderPage);

            List myOrderList = orderPage.getList();
//            for (Object b:myOrderList) {
//                System.out.println(b);
//            }
            model.addAttribute("myOrderList", myOrderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "adminOrder";
    }

//删除订单
    @RequestMapping(value = "admin/deleteOrder",method = RequestMethod.POST)
    @ResponseBody
    public void deleteScene(int orderId){

        adminManageService.deleteOrder(orderId);
    }
}
