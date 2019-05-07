package com.qdu.service;

import com.qdu.dao.AdminInfoDao;
import com.qdu.pojo.Admininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AdminInfoServiceImpl implements AdminInfoService{

    @Autowired
    private AdminInfoDao adminInfoDao;

    @Override
    public Admininfo validateAdmin(String adminId, String adminPassword) {
        Admininfo admin = adminInfoDao.getAdminById(adminId);
        System.out.println(admin.getAdminPassword());
        if(null!=admin&&admin.getAdminPassword().equals(adminPassword)){
            return admin;
        }
        return null;
    }

    @Override
    public Admininfo getAdminById(String adminId) {
        return adminInfoDao.getAdminById(adminId);
    }

    //管理游记
    @Override
    public List manageReport() {
        return  adminInfoDao.manageReport();
    }

    //举报游记的删除
    @Override
    public void delete(int essayId) {
        adminInfoDao.delete(essayId);
    }

    //获取被举报用户的列表
    @Override
    public List getReportUserList() {
        return adminInfoDao.getReportUserList();
    }

    //禁用用户功能
    @Override
    public boolean reportUser(int uid) {
        adminInfoDao.banUser(uid);
        return true;
    }
}
