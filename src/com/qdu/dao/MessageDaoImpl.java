package com.qdu.dao;

import com.qdu.pojo.Message;
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
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private SessionFactory sessionFactory;

    //获取全部留言，分页
    /**
     * 分页查询：根据用户查找用户所有
     *
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return 返回查询记录集合
     */
    @SuppressWarnings("unchecked")
    @Override
    public List messageAll(int offset, int length) {
        List entitylist = null;
        try {
        Query query= sessionFactory.getCurrentSession().createQuery("from Message order by messageTime desc");

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
        Query query = sessionFactory.getCurrentSession().createSQLQuery("select COUNT(*) as num from Message")
                .addScalar("num", StandardBasicTypes.INTEGER)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list = query.list();
        HashMap map = (HashMap) list.get(0);
        int num = (int) map.get("num");
        return num;
    }
//留言
    @Override
    public void toMessage(String uid,String messageContent) {
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("insert into Message ( UId, MessageContent) values(?,?) ");
        query.setParameter(0, uid);
        query.setParameter(1, messageContent);
        query.executeUpdate();
    }


    //根据排序得出新评论的一条评论用于ajax追加

    @Override
    public Message getMessageById() {
        Query query=sessionFactory.getCurrentSession().createQuery("from Message order by messageId desc");
            query.setMaxResults(1);
            return (Message) query.uniqueResult();

    }
}
