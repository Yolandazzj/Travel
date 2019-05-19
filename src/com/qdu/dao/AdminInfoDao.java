package com.qdu.dao;

import com.qdu.page.page;
import com.qdu.pojo.Admininfo;
import com.qdu.pojo.Userinfo;

import java.util.List;

public interface AdminInfoDao extends BaseDao<Userinfo>{
    Admininfo getAdminById(String adminId);
    List manageReport();//查询所有举报的游记
    void delete(int essayId); //删除举报的游记
    List<Userinfo> getReportUserList();//查询被举报用户的列表
    void banUser(String uid);//管理员禁用用户

    page queryForPage(int currentPage, int pageSize) ;//分页查询
    int getAllRowCount();//获取总行数
    List hotelOrderAll(int offset, int length);//所有预定
}
