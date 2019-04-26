package com.qdu.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List messageAll() {
        Query query= sessionFactory.getCurrentSession().createQuery("from Message order by messageTime desc");

        return query.list();
    }
}
