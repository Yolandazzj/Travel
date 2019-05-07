package com.qdu.dao;

import com.qdu.pojo.Admininfo;
import com.qdu.pojo.Userinfo;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminInfoDaoImpl extends BaseDaoImpl<Userinfo> implements AdminInfoDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Admininfo getAdminById(String adminId) {
        Session session = sessionFactory.openSession();
        Admininfo admin = (Admininfo) session.get(Admininfo.class, adminId);
        System.out.println(admin);

        session.close();
        return admin;
    }
    //查询举报的游记
    @Override
    public List manageReport() {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select * from Report");
        query.addScalar("reportId", StandardBasicTypes.INTEGER);
        query.addScalar("essayId", StandardBasicTypes.INTEGER);

        return  query.list();

    }

    //删除举报的游记
    @Override
    public void delete(int essayId) {
//        sessionFactory.getCurrentSession().delete(getEssayById(essayId));
    }

    @Override
    public List<Userinfo> getReportUserList() {
        Session session = sessionFactory.openSession();
        Query query=session.createQuery("from Userinfo where isBan in(0,1)");
        return query.list();

    }

    @Override
    public void banUser(String uid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("update  userinfo set isBan=1 where uid=?");
        query.setString(0, uid);
        query.executeUpdate();
    }
}
