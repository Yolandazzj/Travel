package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.pojo.Scene;
import com.qdu.service.SceneService;
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
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @RequestMapping("user/sceneDetails")
    public String sceneDetails(HttpServletRequest request, String sceneName, int sceneId,Model model){
        sceneName=request.getParameter("sceneName");
        model.addAttribute("sceneName",sceneName);
        sceneId=Integer.parseInt(request.getParameter("sceneId"));
        Scene sceneDetails=sceneService.sceneDetails(sceneId);
        model.addAttribute("sceneDetails",sceneDetails);
        List cityDetails=sceneService.cityDetails(sceneId);
        model.addAttribute("cityDetails",cityDetails);

        return "userSceneDetails";
    }

    @RequestMapping("user/cityDetails")
    public  String cityDetails(HttpServletRequest request,String cityName,int cityId,Model model){
        cityName=request.getParameter("cityName");
        model.addAttribute("cityName",cityName);
        cityId= Integer.parseInt(request.getParameter("cityId"));
        List cityDetail=sceneService.cityDetails(cityId);
        model.addAttribute("cityDetail",cityDetail);
        List proName=sceneService.proNameByCity(cityId);
        model.addAttribute("proName",proName);

        return "userCityDetails";
    }



    //点赞功能(景点)
    @RequestMapping(value = "user/thumb", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb(HttpServletRequest request) {
        Map map = new HashMap<>();
        int sceneId = Integer.parseInt(request.getParameter("sceneId"));
        System.out.println(sceneId);
        boolean flag = sceneService.thumb(sceneId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }

    }

    //获取景点列表，分页
    @RequestMapping("user/sceneAll")
    public String sceneAll(HttpServletRequest request,Model model){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page = sceneService.queryForPage(Integer.valueOf(pageNo),8);
            model.addAttribute("page",page);
            List sceneAll = page.getList();
            model.addAttribute("sceneAll", sceneAll);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "userSceneAll";
    }

}
