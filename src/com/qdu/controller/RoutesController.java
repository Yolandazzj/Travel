package com.qdu.controller;


import com.qdu.page.page;
import com.qdu.pojo.Agency;
import com.qdu.pojo.Route;
import com.qdu.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class RoutesController {

    @Autowired
    private RouteService routeService;


    @RequestMapping("user/routesDetails")
    public String toursDetails(HttpServletRequest request, String routeName, Model model,int routeId){
         routeName=request.getParameter("routeName");
         model.addAttribute("routeName",routeName);
        routeId=Integer.parseInt(request.getParameter("routeId"));
       Route routeDetails= routeService.routeDetails(routeId);
       model.addAttribute("routeDetails",routeDetails);
      List agencyDetails= routeService.agencyDetails(routeId);
      model.addAttribute("agencyDetails",agencyDetails);
      List routeCommentList=routeService.routeComment(routeId);
      model.addAttribute("routeCommentList",routeCommentList);
//       cityId= Integer.parseInt(request.getParameter("cityId"));
//       List cityName=routeService.cityNameById(cityId);
//       model.addAttribute("cityName",cityName);
        return "userRouteDetails";
    }



    @RequestMapping("user/toOrderRoute")
        public String toOrderRoute(HttpServletRequest request,Model model,int routeId){
        Route routeDetails= routeService.routeDetails(routeId);
        model.addAttribute("routeDetails",routeDetails);

            return "orderRoute";
        }

        @RequestMapping("user/toUserOrder")
    public String toUserOrder(){
        return "userOrder";
        }


        @RequestMapping("user/routeForCity")
    public String routeForCity(int cityId,Model model,HttpServletRequest request){
            try {
                String pageNo = request.getParameter("pageNo");
                if (pageNo == null) {
                    pageNo = "1";
                }
                page page = routeService.queryForPageCity(Integer.valueOf(pageNo), 8,cityId);
                model.addAttribute("page", page);
                List cityForRouteAll = page.getList();
                model.addAttribute("cityForRouteAll", cityForRouteAll);
               model.addAttribute("cityName",request.getParameter("cityName"));
                model.addAttribute("cityId",request.getParameter("cityId"));

            } catch (Exception e) {
                e.printStackTrace();
            }
           return "routeForCity";
         }

    //根据城市和好评度搜索路线
    @RequestMapping(value="user/cityIdByScore",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByScore(Model model,HttpServletRequest request,int cityId){
        List searchListByRouteScore=null;
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page page1 = routeService.queryForPageByCityScore(Integer.valueOf(pageNo), 8,cityId);
            model.addAttribute("page1", page1);
            searchListByRouteScore = page1.getList();
            model.addAttribute("searchListByCityRouteScore",searchListByRouteScore);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchListByRouteScore;
    }

    //根据关键词和价格搜索路线
    @RequestMapping(value="user/cityIdByPrice1",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByCityPirce1(Model model,HttpServletRequest request,int cityId){
        List searchListByCityRoutePrice1=null;
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page pagePrice = routeService.queryForPageByCityPrice1(Integer.valueOf(pageNo), 8,cityId);
            model.addAttribute("pagePrice", pagePrice);
            searchListByCityRoutePrice1 = pagePrice.getList();
            model.addAttribute("searchListByCityRoutePrice1",searchListByCityRoutePrice1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchListByCityRoutePrice1;
    }


    //根据关键词和价格搜索路线
    @RequestMapping(value="user/cityIdByPrice2",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByCityPirce2(Model model,HttpServletRequest request,int cityId){
        List searchListByCityRoutePrice2=null;
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page pagePrice2 = routeService.queryForPageByCityPrice2(Integer.valueOf(pageNo), 8,cityId);
            model.addAttribute("pagePrice2", pagePrice2);
            searchListByCityRoutePrice2 = pagePrice2.getList();
            model.addAttribute("searchListByCityRoutePrice2",searchListByCityRoutePrice2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchListByCityRoutePrice2;
    }

    //根据关键词和价格搜索路线
    @RequestMapping(value="user/cityIdByPrice3",method = RequestMethod.POST)
    @ResponseBody
    public List searchRouteByCityPirce3(Model model,HttpServletRequest request,int cityId){
        List searchRouteByCityPirce3=null;
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page pagePrice3 = routeService.queryForPageByCityPrice3(Integer.valueOf(pageNo), 8,cityId);
            model.addAttribute("pagePrice3", pagePrice3);
            searchRouteByCityPirce3 = pagePrice3.getList();
            model.addAttribute("searchRouteByCityPirce3",searchRouteByCityPirce3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchRouteByCityPirce3;
    }
    //根据关键词和价格搜索路线
    @RequestMapping(value="user/searchByCityNo",method = RequestMethod.POST)
    @ResponseBody
    public List searchByNo(Model model,HttpServletRequest request,int cityId){
        List searchRouteByCityNo=null;
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page pagePriceNo = routeService.queryForPageCity(Integer.valueOf(pageNo), 8,cityId);
            model.addAttribute("pagePriceNo", pagePriceNo);
            searchRouteByCityNo = pagePriceNo.getList();
            model.addAttribute("searchRouteByCityNo",searchRouteByCityNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchRouteByCityNo;
    }

}
