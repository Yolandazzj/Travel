package com.qdu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoutesController {

    @RequestMapping("user/routesDetails")
    public String toursDetails(HttpServletRequest request, String routeName, Model model){
         routeName=request.getParameter("routeName");
         model.addAttribute("routeName",routeName);
        return "userRouteDetails";
    }
}
