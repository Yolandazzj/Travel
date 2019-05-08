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
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void toOrder(int routeId, int routeOrderPeople, String routeName, String uid, String routeOrderName, float routePrice,String contact) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("insert into Routeorders ( UId, RouteId,RouteName,RoutePrice,Contact,RouteOrderName,RouteOrderPeople) values(?,?,?,?,?,?,?) ");
        query.setParameter(0, uid);
        query.setParameter(1, routeId);
        query.setParameter(2, routeName);
        query.setParameter(3, routePrice);
        query.setParameter(4, contact);
        query.setParameter(5, routeOrderName);
        query.setParameter(6, routeOrderPeople);

     query.executeUpdate();
    }


    //查看我的所有订单
  @Override
    public List myOrderAll(int offset, int length,String uid) {
        List entitylist = null;
        try {
            Query query= sessionFactory.getCurrentSession().createQuery("from Routeorders where uid=:uid");
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
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Routeorders where uid=?")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter(0,uid)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }
}
