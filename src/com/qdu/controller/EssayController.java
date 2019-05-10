package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.pojo.*;
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
    public String toEssay() {
        return "userEssayAll";
    }

//    @RequestMapping("/toEssayDetails")
//    public String toEssayDetails() {
//        return "userEssayDetails";
//    }

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

    //游记详细信息
    @RequestMapping("/toEssayDetails")
    public String essayDetails(Model model, HttpServletRequest request) {
       // int essayId =(int)( request.getAttribute("essayId"));
        int essayId = 1;
        Essay essayDetails = essayService.essayDetails(essayId);
        model.addAttribute("essayDetails", essayDetails);

        List cityInfo=essayService.cityInfo(essayId);
        model.addAttribute("cityInfo",cityInfo);

        List essayCommentList=essayService.essayComment(essayId);
        model.addAttribute("essayCommentList",essayCommentList);
        return "userEssayDetails";
    }

    //发表游记评论
    @ResponseBody
    @RequestMapping(value="toEssayComment", method = RequestMethod.POST)
    public Essaycomment toEssayComment(int essayId, String uid, String eCommentContent, HttpServletRequest request){
        essayId =Integer.parseInt(request.getParameter("essayId"));
        uid= request.getParameter("uid");
        eCommentContent= request.getParameter("eCommentContent");
        essayService.toEssayComment(essayId, uid, eCommentContent);
        return essayService.getEssayCommentById();
    }

}
