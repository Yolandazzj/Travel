package com.qdu.dao;

import com.qdu.dao.RouteDao;
import com.qdu.pojo.Route;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RouteDaoImpl implements RouteDao {
    @Autowired
    private SessionFactory sessionFactory;


    //返回热门路线列表
    @Override
    public Route hotRoute1() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(0);
        query.setMaxResults(1);
         return (Route) query.uniqueResult();
    }



    @Override
    public Route hotRoute2() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(1);
        query.setMaxResults(1);
        return (Route) query.uniqueResult();
    }

    @Override
    public Route hotRoute3() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(2);
        query.setMaxResults(1);
        return (Route) query.uniqueResult();
    }

    @Override
    public Route hotRoute4() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(3);
        query.setMaxResults(1);
        return (Route) query.uniqueResult();
    }

    @Override
    public Route hotRoute5() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(4);
        query.setMaxResults(1);
        return (Route) query.uniqueResult();
    }

    @Override
    public Route hotRoute6() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(5);
        query.setMaxResults(1);
        return (Route) query.uniqueResult();
    }

    @Override
    public Route hotRoute7() {
        Query query=  sessionFactory.getCurrentSession().createQuery("from Route order by routeScore desc");
        query.setFirstResult(6);
        query.setMaxResults(1);
        return (Route) query.uniqueResult();
    }
}
