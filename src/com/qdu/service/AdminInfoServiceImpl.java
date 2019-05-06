package com.qdu.service;

import com.qdu.dao.AdminInfoDao;
import com.qdu.pojo.Admininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
