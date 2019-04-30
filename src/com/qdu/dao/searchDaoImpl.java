package com.qdu.dao;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class searchDaoImpl implements searchDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List searchAll() {
        SQLQuery query=sessionFactory.openSession().createSQLQuery("select uid,etitle,escore,etime,essayId from Essay where econtent like :keyWord or etitle like :keyWord or categoryId like :keyWord");
        return null;
    }
}
