package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.pojo.Foodinfo;
import com.qdu.service.FStoreService;
import com.qdu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FStoreService fStoreService;

    //美食详细信息
    @RequestMapping("user/foodDetails")
    public String foodDetails(Model model, HttpServletRequest request, int fid, String fname) {
        fname = request.getParameter("fname");
        model.addAttribute("fname", fname);
        fid = Integer.parseInt(request.getParameter("fid"));
        Foodinfo foodDetails = foodService.foodDetails(fid);
        model.addAttribute("foodDetails", foodDetails);
        List cateName=foodService.cateName(fid);
        model.addAttribute("cateName",cateName);
        List storeDetails=foodService.storeDetails(fid);
        model.addAttribute("storeDetails",storeDetails);
        List cityInfo=foodService.cityInfo(fid);
        model.addAttribute("cityInfo",cityInfo);
        List foodCommentList=foodService.foodComment(fid);
        model.addAttribute("foodCommentList",foodCommentList);
        return "userFoodDetails";
    }


    //点赞功能(美食)
    @RequestMapping(value = "user/thumb_food", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_food(HttpServletRequest request) {
        Map map = new HashMap<>();
        int fid = Integer.parseInt(request.getParameter("fid"));
        System.out.println(fid);
        boolean flag = foodService.thumb_food(fid);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }
    }

    //点赞功能(美食评论)
    @RequestMapping(value = "user/thumb_comment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_comment(HttpServletRequest request) {
        Map map = new HashMap<>();
        int fcommentId = Integer.parseInt(request.getParameter("fcommentId"));
        System.out.println(fcommentId);
        boolean flag = foodService.thumb_comment(fcommentId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }
    }

    //获取全部美食列表，分页
    @RequestMapping("user/foodAll")
    public String foodAll(Model model,HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = foodService.queryForPage(Integer.valueOf(pageNo),8);
            model.addAttribute("page",page);
            List foodAll = page.getList();
            model.addAttribute("foodAll", foodAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userFoodAll";

    }

    @RequestMapping("user/storeFoodList")
    public String storeFoodList(Model model,HttpServletRequest request,int did,String dname){
        did = Integer.parseInt(request.getParameter("did"));
        dname = request.getParameter("dname");
        model.addAttribute("dname", dname);
        List storeFoodList=fStoreService.storeFoodList(did);
        model.addAttribute("storeFoodList",storeFoodList);

        return "userFStoreDetails";
    }

}
