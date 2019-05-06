package com.qdu.dao;

import com.qdu.pojo.Admininfo;
import com.qdu.pojo.Userinfo;

public interface AdminInfoDao extends BaseDao<Userinfo>{
    Admininfo getAdminById(String adminId);
}
