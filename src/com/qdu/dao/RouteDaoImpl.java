package com.qdu.dao;

import com.qdu.dao.RouteDao;
import com.qdu.pojo.Agency;
import com.qdu.pojo.City;
import com.qdu.pojo.Route;
import com.qdu.pojo.Routecomment;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
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

    @Override
    public Route routeDeatils(int routeId) {
       Query query= sessionFactory.getCurrentSession().createQuery("from Route where routeId=?");
       query.setParameter(0,routeId);
        return (Route)query.uniqueResult();
    }

    @Override
    public List<Agency> agencyDetails(int routeId) {
       SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select a.* from Route r,Agency a where a.agencyId=r.agencyId and r.routeId=?");
        query.addScalar("agencyId", StandardBasicTypes.INTEGER);
        query.addScalar("agencyName", StandardBasicTypes.STRING);
        query.addScalar("agencyContact", StandardBasicTypes.STRING);
        query.addScalar("agencyScore", StandardBasicTypes.INTEGER);
        query.addScalar("agencyContent", StandardBasicTypes.STRING);
        query.setParameter(0,routeId);

        return  query.list();
    }

    @Override
    public List<Routecomment> routeComment(int routeId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select b.* from Route r,Routecomment b where r.routeId=b.routeId and r.routeId=?");
        query.setParameter(0,routeId);
        query.addScalar("rcommentId", StandardBasicTypes.INTEGER);
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("routeId", StandardBasicTypes.INTEGER);
        query.addScalar("rcommentContent", StandardBasicTypes.STRING);
        query.addScalar("rcommentScore", StandardBasicTypes.INTEGER);
        query.addScalar("rcommentTime", StandardBasicTypes.TIMESTAMP);
        query.addScalar("uid", StandardBasicTypes.STRING);
        return query.list();
    }

    @Override
    public List<City> cityNameById(int cityId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Route r,City c where r.cityId=c.cityId and r.cityId=?");
        query.setParameter(0,cityId);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("cityScore", StandardBasicTypes.INTEGER);
        query.addScalar("cityImage", StandardBasicTypes.STRING);
        query.addScalar("provinceId", StandardBasicTypes.INTEGER);

        return query.list();
    }
}
