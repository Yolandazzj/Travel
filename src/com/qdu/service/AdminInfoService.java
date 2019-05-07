package com.qdu.service;

import com.qdu.pojo.Admininfo;

import java.util.List;

public interface AdminInfoService {
    Admininfo validateAdmin(String adminId, String adminPassword);

    Admininfo getAdminById(String adminId);

    List manageReport();//获取举报的游记

    void delete(int essayId);//删除举报的游记

    List getReportUserList();//获取被举报用户的列表

    boolean reportUser(int uid);//禁用用户
}
