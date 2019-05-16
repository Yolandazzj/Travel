package com.qdu.controller;

import com.qdu.pojo.*;
import com.qdu.service.CityService;
import com.qdu.service.HotelService;
import com.qdu.utils.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private CityService cityService;

    @RequestMapping("/toHotel")
    public String toLogin() {
        return "userHotel";
    }

    //酒店详细信息
    @RequestMapping("/toHotelDetails")
    public String hotelDetails(Model model, HttpServletRequest request, Integer hotelId) {
        hotelId = Integer.parseInt(request.getParameter("hotelId"));
        Hotel hotelDetails = hotelService.hotelDetails(hotelId);
        model.addAttribute("hotelDetails", hotelDetails);
        List<City> cityInfo = hotelService.cityInfo(hotelId);
        model.addAttribute("cityInfo", cityInfo);
        List<Hotelcomment> hotelCommentList = hotelService.hotelComment(hotelId);
        model.addAttribute("hotelCommentList", hotelCommentList);
        List<Layout> layoutInfo = hotelService.layoutInfo(hotelId);
        model.addAttribute("layoutInfo", layoutInfo);
        return "userHotelDetails";
    }

    //点赞功能(酒店)
    @RequestMapping(value = "thumb_hotel", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_hotel(HttpServletRequest request) {
        Map map = new HashMap<>();
        int hotelId = Integer.parseInt(request.getParameter("hotelId"));
        System.out.println(hotelId);
        boolean flag = hotelService.thumb_hotel(hotelId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }
    }

    //点赞功能(酒店评论)
    @RequestMapping(value = "thumb_hotelComment", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> thumb_hotelComment(HttpServletRequest request) {
        Map map = new HashMap<>();
        int hcommentId = Integer.parseInt(request.getParameter("hcommentId"));
        System.out.println(hcommentId);
        boolean flag = hotelService.thumb_comment(hcommentId);
        if (flag) {
            map.put("msg", "点赞成功");
            return map;
        } else {
            map.put("msg", "点赞失败");
            return map;
        }
    }

    //发表游记评论
    @ResponseBody
    @RequestMapping(value = "/toHotelComment", method = RequestMethod.POST)
    public Hotelcomment toHotelComment(int hotelId, String uid, String hCommentContent, HttpServletRequest request) {
        hotelId = Integer.parseInt(request.getParameter("hotelId"));
        uid = request.getParameter("uid");
        hCommentContent = request.getParameter("hCommentContent");
        hotelService.toHotelComment(hotelId, uid, hCommentContent);
        return hotelService.getHotelCommentById();
    }

    //去预定酒店
    @RequestMapping(value = "/toOrderHotel")
    public String toOrderHotel(Model model) {
        List proList = cityService.proList();
        model.addAttribute("proList", proList);
//        List cityList = hotelService.getHotelByCity(cityId);
//        model.addAttribute("proList", proList);
        return "userHotel";
    }
    //根据城市id获取酒店数据后直接使用@ResponseBody装成json数据
    @RequestMapping(value = "/toGetHotel/{cityId}")
    @ResponseBody
    public Json toGetHotel(@PathVariable("cityId") int cityId){
        List hotelList= hotelService.getHotelByCity(cityId);

        if(hotelList!=null){
            for (Object c:hotelList) {
                System.out.println(c);
            }
            return new Json(true,"success",hotelList);
        }else{
            return new Json(false,"fail",null);
        }
    }

    //根据hotelid获取layout数据后直接使用@ResponseBody装成json数据
    @RequestMapping(value = "/toGetLayout/{hotelId}")
    @ResponseBody
    public Json toGetLayout(@PathVariable("hotelId") int hotelId){
        List layoutList= hotelService.getLayoutByHotel(hotelId);

        if(layoutList!=null){
            for (Object c:layoutList) {
                System.out.println(c);
            }
            return new Json(true,"success",layoutList);
        }else{
            return new Json(false,"fail",null);
        }
    }

    //提交预定
    @RequestMapping("/submitOrder")
    public String submitOrder(int hotelId, String hotelName, float hotelPrice, Integer orderDay, String contact, String orderName, int orderPeople,String uid,Model model){
        hotelService.toOrder(hotelId, hotelName,hotelPrice,orderDay,contact,orderName,orderPeople,uid);
        model.addAttribute("hotelId",hotelId);
        model.addAttribute("hotelName",hotelName);
        model.addAttribute("hotelPrice",hotelPrice);
        model.addAttribute("orderDay",orderDay);
        model.addAttribute("contact",contact);
        model.addAttribute("orderName",orderName);
        model.addAttribute("orderPeople",orderPeople);
        model.addAttribute("uid",uid);
        return "userOrder";
    }

}
