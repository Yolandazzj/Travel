package com.qdu.controller;

import com.qdu.pojo.Group;
import com.qdu.service.CityService;
import com.qdu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qdu.utils.DateUtils;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private CityService cityService;

    //组团游申请表单数据插入到group表中
    @ResponseBody
    @RequestMapping(value="user/submitGroup", method = RequestMethod.POST)
    public String toGroup(String uid,String contact,String gtime,String gendTime,float gprice,int gquatity,int cityId,String gcontent, HttpServletRequest request){
        System.out.println(gtime);
        cityId=Integer.parseInt(request.getParameter("cityId"));
        gtime=request.getParameter("gtime");
        gendTime=request.getParameter("gendTime");
        gprice=Float.parseFloat(request.getParameter("gprice"));
        gquatity=Integer.parseInt(request.getParameter("gquatity"));
        gcontent=request.getParameter("gcontent");
        uid=request.getParameter("uid");
        contact=request.getParameter("contact");
        groupService.toGroup(cityId,gtime,gprice,gquatity,gendTime,gcontent,uid,contact);
        return "userGroupAll";
    }

    //组团游申请
    @RequestMapping("user/group")
    public String group(Model model, HttpServletRequest request){
        List proList=cityService.proList();
        model.addAttribute("proList",proList);
        return "userGroup";
    }

    //管理员批准组团游
    @RequestMapping(value = "admin/approveGroup",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> approveGroup(HttpServletRequest request){
        Map map = new HashMap<>();
        int gid = Integer.parseInt(request.getParameter("gid"));
        System.out.println(gid);
        boolean flag = groupService.approve_group(gid);
        if (flag) {
            map.put("msg", "批准成功");
            return map;
        } else {
            map.put("msg", "批准失败");
            return map;
        }
    }



}
