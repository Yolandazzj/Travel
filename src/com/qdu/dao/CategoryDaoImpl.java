package com.qdu.dao;

import com.qdu.pojo.Foodinfo;
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
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List categoryList() {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select * from Category ");
        query.addScalar("fcategoryId", StandardBasicTypes.INTEGER);
        query.addScalar("fcategoryName", StandardBasicTypes.STRING);
        return query.list();
    }

//    @Override
//    public List<Foodinfo> foodCateList(int fcategoryId) {
//        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select f.* from Category c,Foodinfo f where c.fcategoryId=f.fcategoryId and f.fcategoryId=?");
//        query.addScalar("fid", StandardBasicTypes.INTEGER);
//        query.addScalar("fname", StandardBasicTypes.STRING);
//        query.addScalar("fscore", StandardBasicTypes.INTEGER);
//        query.setParameter(0,fcategoryId);
//        return query.list();
//    }

    //分页查询，获取该类别的美食列表
    @Override
    public List foodCateAll(int offset, int length,int fcategoryId) {
        List foodCateList=null;
        try{
            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("select f.* from Category c,Foodinfo f where c.fcategoryId=f.fcategoryId and f.fcategoryId=?");
            query.setParameter(0,fcategoryId);
            query.addScalar("fid", StandardBasicTypes.INTEGER);
            query.addScalar("fcategoryId", StandardBasicTypes.INTEGER);
            query.addScalar("did", StandardBasicTypes.INTEGER);
            query.addScalar("fname", StandardBasicTypes.STRING);
            query.addScalar("fscore", StandardBasicTypes.INTEGER);
            query.addScalar("fimage", StandardBasicTypes.STRING);
            query.addScalar("fprice", StandardBasicTypes.FLOAT);
            query.setFirstResult(offset);
            query.setMaxResults(length);
            foodCateList=query.list();
        }catch(RuntimeException re){
            throw re;
        }
        return foodCateList;
    }

    //返回结果的条数
    @Override
    public int getAllRowCount(int fcategoryId) {
        Query query=sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Category c,Foodinfo f where c.fcategoryId=f.fcategoryId and f.fcategoryId=?")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        query.setParameter(0,fcategoryId);
        List foodCateList = query.list();
        HashMap map = (HashMap) foodCateList.get(0);
        int num = (int) map.get("num");
        return num;
    }
}
