package com.qdu.controller;

import com.qdu.pojo.Admininfo;
import com.qdu.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminInfoController {
    @Autowired
    private AdminInfoService adminInfoService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "adminLogin";
    }

    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(String adminId, String adminPassword, HttpSession session, HttpServletRequest request) {
        Admininfo admin = adminInfoService.getAdminById(adminId);
        System.out.println(request.getParameter("adminPassword"));
        System.out.println(adminPassword);
        if (null == admin) {
            return "{\"msg\":\"用户名不存在，请检查\"}";
        }
        if (!(admin.getAdminPassword().equals(adminPassword))){

                return "用户密码错误";
            }
            session.setAttribute("admin", admin);
            return "<script language='javascript' type='text/javascript'>window.location.href='/Travel'</script>";


        }



}
