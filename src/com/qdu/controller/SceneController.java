package com.qdu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SceneController {

    @RequestMapping("user/sceneDetails")
    public String sceneDetails(HttpServletRequest request, String sceneName, Model model){
        sceneName=request.getParameter("sceneName");
        model.addAttribute("sceneName",sceneName);
        return "userSceneDetails";
    }
}
