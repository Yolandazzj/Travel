package com.qdu.dao;

import com.qdu.pojo.City;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao{

    @Autowired
    private SessionFactory sessionFactory;

    //点赞城市
    @Override
    public void thumb_city(int cityId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call dianzan_city(?)}");
        query.setInteger(0, cityId);
        query.executeUpdate();
    }

    //获取省份列表；
    @Override
    public List proList() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Province ");
        return query.list();
    }

    //通过省份ID获取城市列表；
    @Override
    public List<City> getCityByPro(int provinceId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Province p,City c where p.provinceId=c.provinceId and p.provinceId=?");
        query.setInteger(0, provinceId);
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        query.addScalar("provinceId", StandardBasicTypes.INTEGER);
        query.addScalar("cityScore", StandardBasicTypes.INTEGER);
        query.addScalar("cityImage", StandardBasicTypes.STRING);
        return query.list();
    }
}
