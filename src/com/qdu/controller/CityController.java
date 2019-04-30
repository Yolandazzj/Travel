package com.qdu.controller;

import com.qdu.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    //点赞功能（城市）
    @RequestMapping(value = "user/thumb_city", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_city(HttpServletRequest request) {
        Map map = new HashMap<>();
        int cityId = Integer.parseInt(request.getParameter("cityId"));
        System.out.println(cityId);
        boolean flag = cityService.thumb_city(cityId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }

    }
}
