package com.qdu.dao;

import com.qdu.pojo.Foodinfo;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FStoreDaoImpl implements FStoreDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Foodinfo> storeFoodList(int did) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select f.* from Foodinfo f,Foodstore fs where f.Did=fs.Did and fs.DId=?");
        query.addScalar("fid", StandardBasicTypes.INTEGER);
        query.addScalar("fname", StandardBasicTypes.STRING);
        query.addScalar("fscore", StandardBasicTypes.INTEGER);
        query.addScalar("fprice", StandardBasicTypes.FLOAT);
        query.addScalar("fimage", StandardBasicTypes.STRING);
        query.setParameter(0,did);
        return query.list();
    }
}
