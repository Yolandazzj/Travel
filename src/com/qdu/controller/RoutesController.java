package com.qdu.controller;


import com.qdu.pojo.Agency;
import com.qdu.pojo.Route;
import com.qdu.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoutesController {

    @Autowired
    private RouteService routeService;


    @RequestMapping("user/routesDetails")
    public String toursDetails(HttpServletRequest request, String routeName, Model model,int routeId,int cityId){
         routeName=request.getParameter("routeName");
         model.addAttribute("routeName",routeName);
        routeId=Integer.parseInt(request.getParameter("routeId"));
       Route routeDetails= routeService.routeDetails(routeId);
       model.addAttribute("routeDetails",routeDetails);
      List agencyDetails= routeService.agencyDetails(routeId);
      model.addAttribute("agencyDetails",agencyDetails);
      List routeCommentList=routeService.routeComment(routeId);
      model.addAttribute("routeCommentList",routeCommentList);
       cityId= Integer.parseInt(request.getParameter("cityId"));
       List cityName=routeService.cityNameById(cityId);
       model.addAttribute("cityName",cityName);
        return "userRouteDetails";
    }
}
