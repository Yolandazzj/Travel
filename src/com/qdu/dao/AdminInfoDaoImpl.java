package com.qdu.dao;

import com.qdu.pojo.Admininfo;
import com.qdu.pojo.Userinfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminInfoDaoImpl extends BaseDaoImpl<Userinfo> implements AdminInfoDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Admininfo getAdminById(String adminId) {
        Session session = sessionFactory.openSession();
        Admininfo admin = (Admininfo) session.get(Admininfo.class, adminId);
        System.out.println(admin);

        session.close();
        return admin;
    }
}
