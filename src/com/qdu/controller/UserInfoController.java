
package com.qdu.controller;

import com.qdu.pojo.Userinfo;
import com.qdu.service.UserInfoService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "user_login";
    }

    @RequestMapping(value = "/login", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(String uid, String upassword, HttpSession session) {
        // 这里先查下用户名是否存在
        //存在就返回了
        Userinfo user = userInfoService.getUserById(uid);
        if (null == user) {
            return "{\"msg\":\"用户名不存在，请检查\"}";
        } else {


            user = userInfoService.validateUser(uid, upassword);
            if (null == user) {
                return "{\"msg\":\"用户名或者密码错误，请重新登录\"}";
            }
            int isBan = user.getIsBan();
            if (user.getIsBan().equals(1)) {
                return "您已被禁用";
            } else {
                session.setAttribute("user", user);
                return "<script language='javascript' type='text/javascript'>window.location.href='/Travel'</script>";


            }
        }

    }

    @RequestMapping(value = "/loginout")
    public String loginout(HttpSession session, ModelMap map) throws IOException {
        session.removeAttribute("user");
        return "redirect:/index";
    }


    @RequestMapping("/toRegister")
    public String toRegister() {
        return "user_register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
    public String register(Userinfo userInfo) {
        userInfoService.add(userInfo);
        return "user_login";
    }

    @RequestMapping("/toCenter")
    public String toCenter() {
        return "userCenter";
    }

    @RequestMapping("/editInfo")
    public String editInfo(Userinfo userInfo, Model model) {
        userInfoService.update(userInfo);
        model.addAttribute("userInfoList", userInfoService.getUserInfoList());
        return "user_loginSuccess";

    }


}




