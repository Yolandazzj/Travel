
package com.qdu.dao;

import com.qdu.pojo.Userinfo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<Userinfo> implements UserInfoDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Userinfo getUserById(String uid) {
        Session session = sessionFactory.openSession();
        Userinfo user = (Userinfo) session.get(Userinfo.class, uid);
        session.close();
        return user;
    }

    @Override
    public void insert(Userinfo userInfo) {
        sessionFactory.getCurrentSession().save(userInfo);
    }

    @Override
    public void update(Userinfo userInfo) {
        sessionFactory.getCurrentSession().update(userInfo);
    }

    @Override
    public List getUserInfoList() {
        return sessionFactory.getCurrentSession().createQuery("from Userinfo").list();
    }

    @Override
    public Userinfo checkName(String uid) {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery(" select uid From Userinfo  where uid=?");
        query.setParameter(0, uid);
        session.close();
        return  (Userinfo) query.uniqueResult();


    }


}
