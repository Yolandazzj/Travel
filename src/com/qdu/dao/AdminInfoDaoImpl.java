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
    public List getReportUserList() {
        SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery("select uid,isBan from Userinfo where isBan=1");
        query.addScalar("uid", StandardBasicTypes.INTEGER);
        query.addScalar("isBan", StandardBasicTypes.INTEGER);
        return  query.list();
    }

    @Override
    public void banUser(int uid) {
        Query query = sessionFactory.getCurrentSession().createSQLQuery("{call banUser(?)}");
        query.setInteger(0, uid);
        query.executeUpdate();
    }
}
