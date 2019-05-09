package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.pojo.Essay;
import com.qdu.service.CityService;
import com.qdu.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class EssayController {
    @Autowired
    private EssayService essayService;

    @Autowired
    private CityService cityService;

    //去发表游记
    @RequestMapping(value = "/toWriteEssay")
    public String toWriteEssay(Model model){
        List proList=cityService.proList();
        model.addAttribute("proList",proList);
        return "userEssay";
    }

    @RequestMapping("/toEssay")
    public String toLogin() {
        return "userEssayAll";
    }

    //添加游记

    @RequestMapping("/addEssay")
    public String addEssay(Essay newEssay) {
        essayService.add(newEssay);
//        try {
//            String pageNo = request.getParameter("pageNo");
//            if (pageNo == null) {
//                pageNo = "1";
//            }
//            uid = request.getParameter("uid") ;
//            page page = essayService.queryForPage(Integer.valueOf(pageNo), 6,uid);
//            model.addAttribute("page", page);
//            List essay = page.getList();
//            model.addAttribute("myEssayList", essay);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return "userEssayAll";
    }

}
