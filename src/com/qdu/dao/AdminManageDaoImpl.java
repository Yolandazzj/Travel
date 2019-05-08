package com.qdu.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository

public class AdminManageDaoImpl implements AdminManageDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List myOrderAll(int offset, int length) {
        List entitylist = null;
        try {
            Query query= sessionFactory.getCurrentSession().createQuery("from Routeorders");
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

    @Override
    public int getAllRowCount() {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Routeorders")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }

    //管理员删除订单
    @Override
    public void deleteOrder(int orderId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE from Routeorders where routeOrderId=?");
        query.setInteger(0, orderId);
        query.executeUpdate();
    }
}
