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
public class HotelDaoImpl implements HotelDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Hotel hotHotel1() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotHotel2() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(1);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotHotel3() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(2);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotHotel4() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(3);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotHotel5() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(4);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotHotel6() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(5);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotHotel7() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hotel order by hotelScore desc");
        query.setFirstResult(6);
        query.setMaxResults(1);
        return (Hotel) query.uniqueResult();
    }

    @Override
    public Hotel hotelDetails(int hotelId) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Hotel where hotelId=?");
        query.setParameter(0,hotelId);
        return (Hotel) query.uniqueResult();
    }

    //获取房型
    @Override
    public List<Layout> layoutInfo(int hotelId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select l.hotelId,l.layoutPrice,l.layoutImage,l.layoutSize,l.layoutBed from layout l,hotel h where h.hotelId = l.hotelId and l.hotelId=? ");
        query.addScalar("hotelId", StandardBasicTypes.INTEGER);
        query.addScalar("layoutPrice", StandardBasicTypes.FLOAT);
        query.addScalar("layoutImage", StandardBasicTypes.STRING);
        query.addScalar("layoutSize", StandardBasicTypes.STRING);
        query.addScalar("layoutBed", StandardBasicTypes.STRING);
        query.setParameter(0,hotelId);
        return query.list();
    }

    //根据酒店ID获取所在城市的名字；（hotelId  -> cityId -> cityName）;
    @Override
    public List<City> cityInfo(int hotelId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.cityId,c.cityImage,c.cityName from hotel h,city c where  h.CityId=c.CityId and h.hotelId=?");
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        query.addScalar("cityImage", StandardBasicTypes.STRING);
        query.setParameter(0,hotelId);
        return query.list();
    }

    //获取评论
    @Override
    public List<Hotelcomment> hotelComment(int hotelId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.hCommentId,c.uid,c.hCommentContent,c.hCommentScore,c.hCommentTime from Hotel h,Hotelcomment c where h.hotelId=c.hotelId and h.hotelId=?");
        query.setParameter(0,hotelId);
        query.addScalar("hCommentId", StandardBasicTypes.INTEGER);
        query.addScalar("uid", StandardBasicTypes.STRING);
        query.addScalar("hCommentContent", StandardBasicTypes.STRING);
        query.addScalar("hCommentScore", StandardBasicTypes.INTEGER);
        query.addScalar("hCommentTime", StandardBasicTypes.TIMESTAMP);
        return query.list();
    }

    @Override
    public void thumb_hotel(int hotelId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("update  hotel set hotelscore=hotelscore+1 where hotelId=?");
        query.setInteger(0, hotelId);
        query.executeUpdate();
    }

    @Override
    public void thumb_comment(int hCommentId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("update  hotelComment set hCommentScore=hCommentScore+1 where hCommentId=?");
        query.setInteger(0, hCommentId);
        query.executeUpdate();
    }

    @Override
    public void toHotelComment(int hotelId, String uid, String hCommentContent) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("insert into hotelcomment (hotelId, UId, hCommentContent) values(?,?,?) ");
        query.setParameter(0,hotelId);
        query.setParameter(1, uid);
        query.setParameter(2, hCommentContent);
        query.executeUpdate();
    }

    @Override
    public Hotelcomment getHotelCommentById(int hotelId) {
        Query query=sessionFactory.getCurrentSession().createQuery("from hotelcomment where hotelId=? order by hCommentId desc");
        query.setInteger(0,hotelId);
        query.setMaxResults(1);
        return (Hotelcomment) query.uniqueResult();
    }

    //返回结果的条数
    @Override
    public int getAllRowCount() {
        Query query=sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from `hotel`")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);//需要关联一张表，未改
        List hotelList = query.list();
        HashMap map = (HashMap) hotelList.get(0);
        int num = (int) map.get("num");
        return num;
    }

    @Override
    public List hotelAll(int offset, int length) {
        List hotelList=null;
        try{
            Query query=sessionFactory.getCurrentSession().createQuery("from Hotel");//需要关联，未改
            query.setFirstResult(offset);
            query.setMaxResults(length);
            hotelList=query.list();
        }catch(RuntimeException re){
            throw re;
        }
        return hotelList;
    }

    //通过城市ID获取酒店列表；
    @Override
    public List<Hotel> getHotelByCity(int cityId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select h.* from Hotel h,City c where h.cityId=c.cityId and h.cityId=?");
        query.setInteger(0, cityId);
        query.addScalar("hotelId", StandardBasicTypes.INTEGER);
        query.addScalar("hotelName", StandardBasicTypes.STRING);
        query.addScalar("hotelPrice", StandardBasicTypes.FLOAT);
        query.addScalar("hotelScore", StandardBasicTypes.INTEGER);
        query.addScalar("hotelImage", StandardBasicTypes.STRING);
        return query.list();
    }
}
