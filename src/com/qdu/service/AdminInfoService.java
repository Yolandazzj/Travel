package com.qdu.service;

import com.qdu.pojo.Admininfo;

public interface AdminInfoService {
    Admininfo validateAdmin(String adminId,String adminPassword);
    Admininfo getAdminById(String adminId);
}
