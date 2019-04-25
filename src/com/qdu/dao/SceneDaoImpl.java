package com.qdu.dao;


import com.qdu.pojo.City;
import com.qdu.pojo.Scene;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<City> cityDetails(int sceneId) {
        return null;
    }
}
