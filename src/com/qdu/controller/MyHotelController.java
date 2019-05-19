package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.service.MyHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyHotelController {
    @Autowired
    private MyHotelService myHotelService;
    @RequestMapping("user/myHotel")
    public String myHotel(String uid, Model model, HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page orderPage = myHotelService.queryForPage(Integer.valueOf(pageNo), 3,uid);
            model.addAttribute("orderPage", orderPage);

            List myHotelList = orderPage.getList();
            for (Object b:myHotelList) {
                System.out.println(b);
            }
            model.addAttribute("myHotelList", myHotelList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "myHotel";
    }
}
