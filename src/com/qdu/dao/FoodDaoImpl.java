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
public class FoodDaoImpl implements  FoodDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Foodinfo hotFood1() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo hotFood2() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(1);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo hotFood3() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(2);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo hotFood4() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(3);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo hotFood5() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(4);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo hotFood6() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(5);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo hotFood7() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Foodinfo order by fscore desc");
        query.setFirstResult(6);
        query.setMaxResults(1);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public Foodinfo foodDetails(int fid) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Foodinfo where fid=?");
        query.setParameter(0,fid);
        return (Foodinfo) query.uniqueResult();
    }

    @Override
    public List<Category> cateName(int fid) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Foodinfo f,Category c where c.FCategoryId=f.FCategoryId and f.FId=?");
        query.addScalar("fcategoryId", StandardBasicTypes.INTEGER);
        query.addScalar("fcategoryName", StandardBasicTypes.STRING);
        query.setParameter(0,fid);
        return query.list();
    }

    @Override
    public List<Foodstore> storeDetails(int fid) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select fs.* from Foodinfo f,Foodstore fs where fs.DId=f.DId and f.FId=?");
        query.addScalar("did", StandardBasicTypes.INTEGER);
        query.addScalar("dname", StandardBasicTypes.STRING);
        query.addScalar("daddress", StandardBasicTypes.STRING);
        query.setParameter(0,fid);
        return query.list();
    }

    @Override
    public List<City> cityInfo(int fid) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Foodinfo f,Foodstore fs,City c where fs.DId=f.DId and fs.CityId=c.CityId and f.FId=?");
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        query.setParameter(0,fid);
        return query.list();
    }

    @Override
    public List<Foodcomment> foodComment(int fid) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Foodinfo f,Foodcomment c where f.fId=c.fId and f.fId=?");
        query.setParameter(0,fid);
        query.addScalar("fcommentId", StandardBasicTypes.INTEGER);
        query.addScalar("fid", StandardBasicTypes.INTEGER);
        query.addScalar("uid", StandardBasicTypes.STRING);
        query.addScalar("fcommentContent", StandardBasicTypes.STRING);
        query.addScalar("fcommentScore", StandardBasicTypes.INTEGER);
        query.addScalar("fcommentTime", StandardBasicTypes.TIMESTAMP);
        return query.list();
    }

    //获取美食列表
    @Override
    public List foodList() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Foodinfo order by FScore desc");
        query.setFirstResult(0);
        query.setMaxResults(7);
        return query.list();
    }

    //分页查询，美食列表
    @Override
    public List foodAll(int offset, int length) {
        List foodList=null;
        try{
            Query query=sessionFactory.getCurrentSession().createQuery("from Foodinfo order by FScore desc");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            foodList=query.list();
        }catch(RuntimeException re){
            throw re;
        }
        return foodList;
    }


    //返回结果的条数
    @Override
    public int getAllRowCount() {
        Query query=sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Foodinfo")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List foodList = query.list();
        HashMap map = (HashMap) foodList.get(0);
        int num = (int) map.get("num");
        return num;
    }


    //点赞美食
    @Override
    public void thumb_food(int fid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call dianzan_food(?)}");
        query.setInteger(0, fid);
        query.executeUpdate();
    }

    //点赞美食评论
    @Override
    public void thumb_comment(int fcommentId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call dianzan_comment(?)}");
        query.setInteger(0, fcommentId);
        query.executeUpdate();
    }

    //发表美食评论
    @Override
    public void toFoodComment(int fid,String uid, String fcommentContent) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("insert into Foodcomment (FId, UId, FCommentContent) values(?,?,?) ");
        query.setParameter(0,fid);
        query.setParameter(1, uid);
        query.setParameter(2, fcommentContent);
        query.executeUpdate();
    }

    //获取最新的美食评论，ajax追加
    @Override
    public Foodcomment getFoodCommentById() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Foodcomment order by fcommentId desc");
        query.setMaxResults(1);
        return (Foodcomment) query.uniqueResult();
    }
}
