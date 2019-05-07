package com.qdu.controller;

import com.qdu.pojo.Admininfo;
import com.qdu.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
            return "用户名不存在，请检查";
        }
        if (!(admin.getAdminPassword().equals(adminPassword))) {
            return "用户密码错误";
        }
        session.setAttribute("admin", admin);
        return "<script language='javascript' type='text/javascript'>window.location.href='/Travel/admin/toCenter'</script>";
    }

    @RequestMapping(value = "/loginout")
    public String loginout(HttpSession session, ModelMap map) throws IOException {
        session.removeAttribute("user");
        return "redirect:/index";
    }

    @RequestMapping("/toCenter")
    public String toCenter() {
        return "adminCenter";
    }

    //举报列表
    @RequestMapping("/manageReport")
    public String manageReport(Model model){
        List reportList=adminInfoService.manageReport();
        model.addAttribute("reportList", reportList);

        return "reportList";
    }


    //删除
    @RequestMapping(value = "/deleteEssay", method = RequestMethod.POST)
    @ResponseBody
    public void deleteEssay(int essayId) {
        adminInfoService.delete(essayId);
    }

    //被举报用户
    @RequestMapping(value = "/manageUser")
    public String manageUser(Model model) {
        System.out.println(adminInfoService.getReportUserList().get(0).getUid());
        List reportUserList = adminInfoService.getReportUserList();
        model.addAttribute("reportUserList", reportUserList);
        return "adminManageUser";

    }

    //禁用用户
    @RequestMapping(value = "/banUser")
    @ResponseBody
    public void reportUser(HttpServletRequest request) {
        String uid =request.getParameter("uid");
        System.out.println(uid);
        adminInfoService.reportUser(uid);


    }

}
