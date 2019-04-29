package com.qdu.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl implements CityDao{

    @Autowired
    private SessionFactory sessionFactory;

    //点赞城市
    @Override
    public void thumb_city(int cityId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call dianzan_city(?)}");
        query.setInteger(0, cityId);
        query.executeUpdate();
    }
}
