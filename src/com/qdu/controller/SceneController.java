package com.qdu.controller;

import com.qdu.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @RequestMapping("user/sceneDetails")
    public String sceneDetails(HttpServletRequest request, String sceneName, int sceneId,Model model){
        sceneName=request.getParameter("sceneName");
        model.addAttribute("sceneName",sceneName);
        sceneId=Integer.parseInt(request.getParameter("sceneId"));
        List cityDetails=sceneService.cityDetails(sceneId);
        model.addAttribute("cityDetails",cityDetails);
        return "userSceneDetails";
    }
}
