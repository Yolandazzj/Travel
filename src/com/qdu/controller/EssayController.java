package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Essay;
import com.qdu.service.CityService;
import com.qdu.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
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

    @ResponseBody
    @RequestMapping(value="addEssay", method = RequestMethod.POST)
    public String toGroup(String eTitle,String uid, String eContent,int cityId, HttpServletRequest request){
        cityId=Integer.parseInt(request.getParameter("cityId"));
        eTitle=request.getParameter("eTitle");
        uid=request.getParameter("uid");
        eContent=request.getParameter("eContent");
        essayService.toEssay(eTitle,uid,eContent,cityId );
        return "userEssayAll";
    }

}
