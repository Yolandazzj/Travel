package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.Admininfo;
import com.qdu.pojo.Userinfo;

import java.util.List;

public interface AdminInfoService {
    Admininfo validateAdmin(String adminId, String adminPassword);

    Admininfo getAdminById(String adminId);

    List manageReport();//获取举报的游记

    void delete(int essayId);//删除举报的游记

    List<Userinfo> getReportUserList();//获取被举报用户的列表

    boolean reportUser(String uid);//禁用用户

    page queryForPage(int currentPage, int pageSize) ;//分页查询

}
