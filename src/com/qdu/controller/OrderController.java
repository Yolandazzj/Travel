package com.qdu.controller;

import com.qdu.page.page;
import com.qdu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @RequestMapping("user/myOrder")
    public String myOrder(String uid, Model model, HttpServletRequest request){
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            page orderPage = orderService.queryForPage(Integer.valueOf(pageNo), 3,uid);
            model.addAttribute("orderPage", orderPage);

            List myOrderList = orderPage.getList();
            for (Object b:myOrderList) {
                System.out.println(b);
            }
            model.addAttribute("myOrderList", myOrderList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "myOrder";
    }
}
