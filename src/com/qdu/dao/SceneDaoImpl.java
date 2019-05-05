package com.qdu.dao;


import com.qdu.pojo.City;
import com.qdu.pojo.Province;
import com.qdu.pojo.Scene;
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
public class SceneDaoImpl implements SceneDao {

    @Autowired
    private SessionFactory sessionFactory;

    //通过景点点赞数倒序获取热门景点；
    @Override
    public Scene hotScene1() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene hotScene2() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(1);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene hotScene3() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(2);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene hotScene4() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(3);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene hotScene5() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(4);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene hotScene6() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(5);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene hotScene7() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(6);
        query.setMaxResults(1);
        return (Scene) query.uniqueResult();
    }

    @Override
    public Scene sceneDetails(int sceneId) {
        Query query=sessionFactory.getCurrentSession().createQuery("from Scene where sceneId=?");
        query.setParameter(0,sceneId);
        return (Scene) query.uniqueResult();
    }

    @Override
    public List sceneList() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
        query.setFirstResult(0);
        query.setMaxResults(7);
        return query.list();
    }

    //根据景点ID获取所在城市信息；
    @Override
    public List cityDetails(int sceneId) {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select c.* from Scene s,City c where c.cityId=s.cityId and s.sceneId=?");
        query.addScalar("cityId", StandardBasicTypes.INTEGER);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        query.addScalar("cityScore", StandardBasicTypes.INTEGER);
        query.addScalar("cityImage", StandardBasicTypes.STRING);
        query.addScalar("provinceId",StandardBasicTypes.INTEGER);
        query.setParameter(0,sceneId);
        return query.list();
    }

    @Override
    public List proNameByCity(int cityId) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select p.* from City c,Province p where c.provinceId=p.provinceId and c.cityId=?");
        query.setParameter(0,cityId);
        query.addScalar("provinceId",StandardBasicTypes.INTEGER);
        query.addScalar("cityName", StandardBasicTypes.STRING);
        return query.list();
    }


    /**
     * 分页查询：根据用户查找用户所有
     *
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return 返回查询记录集合
     */
    @Override
    public List sceneAll(int offset, int length) {
        List sceneList=null;
        try{
            Query query=sessionFactory.getCurrentSession().createQuery("from Scene order by sceneScore desc");
            query.setFirstResult(offset);
            query.setMaxResults(length);
            sceneList=query.list();
        }catch(RuntimeException re){
            throw re;
        }
        return sceneList;
    }

    //返回结果的条数
    @Override
    public int getAllRowCount() {
        Query query=sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Scene")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List sceneList = query.list();
        HashMap map = (HashMap) sceneList.get(0);
        int num = (int) map.get("num");
        return num;
    }

    //点赞景点
    @Override
    public void thumb(int sceneId) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call dianzan_scene(?)}");
        query.setInteger(0, sceneId);
        query.executeUpdate();
    }

}
