package com.qdu.dao;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.type.StandardBasicTypes;

import java.util.HashMap;
import java.util.List;

@Repository
public class SearchDaoImpl implements SearchDao {

    @Autowired
    private SessionFactory sessionFactory;

    //模糊搜索所有关键词----攻略
    @Override
    public List searchEssay(String keyword) {
        SQLQuery query=sessionFactory.openSession().createSQLQuery("select uid,etitle,escore,etime,essayId,econtent from Essay where econtent like :keyWord or etitle like :keyWord");
        query.setParameter("keyWord", "%"+keyword+"%");
        query.addScalar("uid", StandardBasicTypes.INTEGER);
        query.addScalar("etitle", StandardBasicTypes.STRING);
        query.addScalar("escore", StandardBasicTypes.INTEGER);
        query.addScalar("etime", StandardBasicTypes.TIMESTAMP);
        query.addScalar("essayId", StandardBasicTypes.INTEGER);
        query.addScalar("econtent", StandardBasicTypes.STRING);
        return query.list();
    }

    //模糊搜索所有关键词----路线
    @Override
    public List searchRoute(String keyword,int offset, int length) {
        List entitylist = null;
        try {
        Query query=sessionFactory.openSession().createQuery("from Route where routeName like :keyWord");
        query.setParameter("keyWord", "%"+keyword+"%");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }

    //模糊搜索路线结果集条数

    @Override
    public int getAllRowCount(String keyword) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Route where routeName like :keyword")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter("keyword","%"+keyword+"%")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }

    //根据关键字模糊搜索出酒店
    @Override
    public List searchHotel(String keyword) {
        SQLQuery query=sessionFactory.openSession().createSQLQuery("select h.* from Hotel h,City c where h.cityId=c.cityId and c.cityName like :keyword");
        query.setParameter("keyword", "%"+keyword+"%");
        query.addScalar("hotelId", StandardBasicTypes.INTEGER);
        query.addScalar("hotelName", StandardBasicTypes.STRING);
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("hotelPrice", StandardBasicTypes.FLOAT);
        query.addScalar("hotelLevel", StandardBasicTypes.STRING);
        query.addScalar("hotelScore", StandardBasicTypes.INTEGER);
        query.addScalar("hotelImage", StandardBasicTypes.STRING);
        return query.list();
    }

    //模糊搜索根据好评分类路线
    @Override
    public List searchRouteByScore(String keyword,int offset, int length) {
        List entitylist = null;
        try {
            Query query=sessionFactory.openSession().createQuery("from Route where routeName like :keyWord order by routeScore desc");
            query.setParameter("keyWord", "%"+keyword+"%");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }

    //模糊搜索根据好评路线结果集条数

    @Override
    public int getAllRowCountByScore(String keyword) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Route where routeName like :keyword order by routeScore desc")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter("keyword","%"+keyword+"%")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }

    //模糊搜索根据销量分类路线
//    @Override
//    public List searchRouteByNumber(String keyword,int offset, int length) {
//        List entitylist = null;
//        try {
//            Query query=sessionFactory.openSession().createQuery("select count(*) as num,r.* from routeorders r group by r.routeId");
//            query.setParameter("keyWord", "%"+keyword+"%");
//            query.setFirstResult(offset);
//            query.setMaxResults(length);
//            entitylist = query.list();
//        } catch (RuntimeException re) {
//            throw re;
//        }
//
//        return entitylist;
//    }


    //模糊搜索根据价格分类路线
    @Override
    public List searchRouteByPrice1(String keyword,int offset, int length) {
        List entitylist = null;
        try {
            Query query=sessionFactory.openSession().createQuery("from Route where routeName like :keyWord and routePrice<1000 order by routeScore desc");
            query.setParameter("keyWord", "%"+keyword+"%");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }
    //模糊搜索根据好评路线结果集条数

    @Override
    public int getAllRowCountByPrice1(String keyword) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Route where routeName like :keyword and routePrice<1000 order by routeScore desc")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter("keyword","%"+keyword+"%")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }

    //模糊搜索根据价格分类路线
    @Override
    public List searchRouteByPrice2(String keyword,int offset, int length) {
        List entitylist = null;
        try {
            Query query=sessionFactory.openSession().createQuery("from Route where routeName like :keyWord and routePrice>=1000 and routePrice<=2000 order by routeScore desc");
            query.setParameter("keyWord", "%"+keyword+"%");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }
    //模糊搜索根据好评路线结果集条数

    @Override
    public int getAllRowCountByPrice2(String keyword) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Route where routeName like :keyword and routePrice>=1000 and routePrice<=2000 order by routeScore desc")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter("keyword","%"+keyword+"%")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }

    //模糊搜索根据价格分类路线
    @Override
    public List searchRouteByPrice3(String keyword,int offset, int length) {
        List entitylist = null;
        try {
            Query query=sessionFactory.openSession().createQuery("from Route where routeName like :keyWord and routePrice>2000 order by routeScore desc");
            query.setParameter("keyWord", "%"+keyword+"%");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();
        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }
    //模糊搜索根据好评路线结果集条数

    @Override
    public int getAllRowCountByPrice3(String keyword) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Route where routeName like :keyword and routePrice>2000 order by routeScore desc")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setParameter("keyword","%"+keyword+"%")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }

}
