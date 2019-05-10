package com.qdu.dao;

import com.qdu.pojo.*;
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
public class EssayDaoImpl implements EssayDao {

    @Autowired
    private SessionFactory sessionFactory;

    //数据插入到essay表中
    @Override
    public void toEssay(String eTitle,String uid, String eContent,int cityId ) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("insert into `bishe`.`essay` (`eTitle`, `uid`, `eContent`, `CityId`) values(?,?,?,?)");
        query.setParameter(0,eTitle);
        query.setParameter(1,uid);
        query.setParameter(2,eContent);
        query.setParameter(3,cityId);
        query.executeUpdate();
    }

    @Override
    public List essayByScore(int cityId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from Essay where categoryId=? order by escore desc")
                .addScalar("essayId", StandardBasicTypes.STRING)
                .addScalar("etitle", StandardBasicTypes.STRING)
                .addScalar("uid", StandardBasicTypes.INTEGER)
                .addScalar("uname", StandardBasicTypes.STRING)
                .addScalar("econtent", StandardBasicTypes.STRING)
                .addScalar("escore", StandardBasicTypes.INTEGER)
                .addScalar("etime", StandardBasicTypes.DATE)
                .setParameter(0, cityId)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @Override
    public List essayByTime(int cityId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from Essay where categoryId=? order by etime desc")
                .addScalar("essayId", StandardBasicTypes.STRING)
                .addScalar("etitle", StandardBasicTypes.STRING)
                .addScalar("uid", StandardBasicTypes.INTEGER)
                .addScalar("uname", StandardBasicTypes.STRING)
                .addScalar("econtent", StandardBasicTypes.STRING)
                .addScalar("escore", StandardBasicTypes.INTEGER)
                .addScalar("etime", StandardBasicTypes.DATE)
                .setParameter(0, cityId)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    @Override
    public void reportUser(String uid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call checkUser(?)}");
        System.out.println("------------");
        query.setString(0, uid);
        query.executeUpdate();
    }

    @Override
    public List getCityList() {
        Query query= sessionFactory.getCurrentSession().createQuery("from City");
        return query.list();
    }

    /**
     * 分页查询：根据用户查找用户所有
     *
//     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return 返回查询记录集合
     */
    @SuppressWarnings("unchecked")
    @Override
    public List queryForPage(int offset, int length,String uid) {
        List entitylist = null;
        try {
            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select uid,etitle,escore,etime,essayId from Essay where uid=?");
            query.setParameter(0, uid);
            query.addScalar("uid", StandardBasicTypes.STRING);
            query.addScalar("etitle", StandardBasicTypes.STRING);
            query.addScalar("escore", StandardBasicTypes.INTEGER);
            query.addScalar("etime", StandardBasicTypes.TIMESTAMP);
            query.addScalar("essayId", StandardBasicTypes.INTEGER);
            query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            query.setFirstResult(offset);
            query.setMaxResults(length);
            entitylist = query.list();

        } catch (RuntimeException re) {
            throw re;
        }

        return entitylist;
    }
    //返回结果的条数
    @Override
    public int getAllRowCount() {
        Query query=sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from `essay`")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);//需要关联一张表，未改
        List essayList = query.list();
        HashMap map = (HashMap) essayList.get(0);
        int num = (int) map.get("num");
        return num;
    }

    @Override
    public List essayAll(int offset, int length) {
        List essayList=null;
        try{
            Query query=sessionFactory.getCurrentSession().createQuery("from Essay");//需要关联，未改
            query.setFirstResult(offset);
            query.setMaxResults(length);
            essayList=query.list();
        }catch(RuntimeException re){
            throw re;
        }
        return essayList;
    }

    @Override
    public Essay essayDetails(int essayId) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Essay where essayId=?");
        query.setParameter(0,essayId);
        return (Essay) query.uniqueResult();
    }

    //根据游记ID获取所在城市的名字；（essayId  -> cityId -> cityName）;
    @Override
    public List<City> cityInfo(int essayId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Essay e,City c where  e.CityId=c.CityId and e.essayId=?");
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        query.setParameter(0,essayId);
        return query.list();
    }

    //根据游记ID获取评论；
    @Override
    public List<Essaycomment> essayComment(int essayId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Essay e,Essaycomment c where e.essayId=c.fId and f.fId=?");
        query.setParameter(0,essayId);
        query.addScalar("fcommentId", StandardBasicTypes.INTEGER);
        query.addScalar("fid", StandardBasicTypes.INTEGER);
        query.addScalar("uid", StandardBasicTypes.STRING);
        query.addScalar("fcommentContent", StandardBasicTypes.STRING);
        query.addScalar("fcommentScore", StandardBasicTypes.INTEGER);
        query.addScalar("fcommentTime", StandardBasicTypes.TIMESTAMP);
        return query.list();
    }

}
