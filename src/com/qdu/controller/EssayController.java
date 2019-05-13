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
import java.util.*;

@Controller
@RequestMapping("/user")
public class EssayController {
    @Autowired
    private EssayService essayService;

    @Autowired
    private CityService cityService;

    //去发表游记
    @RequestMapping(value = "/toWriteEssay")
    public String toWriteEssay(Model model) {
        List proList = cityService.proList();
        model.addAttribute("proList", proList);
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
    @RequestMapping(value = "addEssay", method = RequestMethod.POST)
    public String toGroup(String eTitle, String uid, String eContent, int cityId, HttpServletRequest request) {
        cityId = Integer.parseInt(request.getParameter("cityId"));
        eTitle = request.getParameter("eTitle");
        uid = request.getParameter("uid");
        eContent = request.getParameter("eContent");
        essayService.toEssay(eTitle, uid, eContent, cityId);
        return "userEssayAll";
    }

    //游记详细信息
    @RequestMapping("/toEssayDetails")
    public String essayDetails(Model model, HttpServletRequest request, Integer essayId) {
        essayId = Integer.parseInt(request.getParameter("essayId"));
        Essay essayDetails = essayService.essayDetails(essayId);
        model.addAttribute("essayDetails", essayDetails);
        List<City> cityInfo = essayService.cityInfo(essayId);
        model.addAttribute("cityInfo", cityInfo);
        List<Essaycomment> essayCommentList = essayService.essayComment(essayId);
        model.addAttribute("essayCommentList", essayCommentList);
        return "userEssayDetails";
    }

    //发表游记评论
    @ResponseBody
    @RequestMapping(value = "toEssayComment", method = RequestMethod.POST)
    public Essaycomment toEssayComment(int essayId, String uid, String eCommentContent, HttpServletRequest request) {
        essayId = Integer.parseInt(request.getParameter("essayId"));
        uid = request.getParameter("uid");
        eCommentContent = request.getParameter("eCommentContent");
        essayService.toEssayComment(essayId, uid, eCommentContent);
        return essayService.getEssayCommentById();
    }

    //点赞功能(游记)
    @RequestMapping(value = "thumb_essay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_essay(HttpServletRequest request) {
        Map map = new HashMap<>();
        int essayId = Integer.parseInt(request.getParameter("essayId"));
        System.out.println(essayId);
        boolean flag = essayService.thumb_essay(essayId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }
    }

    //点赞功能(游记评论)
    @RequestMapping(value = "thumb_essayComment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_Essaycomment(HttpServletRequest request) {
        Map map = new HashMap<>();
        int ecommentId = Integer.parseInt(request.getParameter("ecommentId"));
        System.out.println(ecommentId);
        boolean flag = essayService.thumb_comment(ecommentId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }
    }

    //举报用户
    @RequestMapping(value = "/reportUser")
    @ResponseBody
    public void reportUser(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        System.out.println("uid........." + uid);
        essayService.reportUser(uid);
    }

    //我的游记
    @RequestMapping("/essayMine")
    public String essayMine(String uid,Model model,HttpServletRequest request) {
        System.out.println("uid..."+uid);
        List<Essay> essayMineList = essayService.getEssayMineList(uid);
        model.addAttribute("essayMineList", essayMineList);
        return "userEssayMine";
    }

    //删除游记
    @RequestMapping(value = "/deleteEssay",method=RequestMethod.POST)
    @ResponseBody
    public void deleteEssay(int essayId) {
          essayService.deleteEssay(essayId);
    }


}
