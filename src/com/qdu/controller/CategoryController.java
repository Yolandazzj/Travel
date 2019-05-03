package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //获取美食列表
    @RequestMapping("user/category")
    public String category(Model model, HttpServletRequest request,int fcategoryId,String fcategoryName){

        fcategoryName = request.getParameter("fcategoryName");
        model.addAttribute("fcategoryName", fcategoryName);
        fcategoryId=Integer.parseInt(request.getParameter("fcategoryId"));
//        List foodCateList=categoryService.foodCateList(fcategoryId);
//        model.addAttribute("foodCateList",foodCateList);
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = categoryService.queryForPage(Integer.valueOf(pageNo),8,fcategoryId);
            model.addAttribute("page",page);
            List foodCateList = page.getList();
            model.addAttribute("foodCateList", foodCateList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userCategory";
    }
}
