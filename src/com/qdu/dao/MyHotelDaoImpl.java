package com.qdu.dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public class MyHotelDaoImpl implements MyHotelDao {
    @Autowired
    private SessionFactory sessionFactory;

    //hotel
    @Override
    public List myHotelAll(int offset, int length, String uid) {
        List entitylist = null;
        try {
            Query query= sessionFactory.getCurrentSession().createQuery("from Hotelorders where uid=:uid");
            query.setParameter("uid",uid);
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
            for (Object o:entitylist
            ) {
                System.out.println(o);
            }

        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }

    //返回结果的条数
    @Override
    public int getAllRowCount(String uid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Hotelorders where uid=?")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter(0,uid)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }
}
