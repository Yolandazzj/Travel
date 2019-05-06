package com.qdu.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AgencyDaoImpl implements AgencyDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List agencyAll() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Agency order by agencyScore ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        return query.list();
    }
}
