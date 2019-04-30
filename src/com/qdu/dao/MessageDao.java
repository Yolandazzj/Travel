package com.qdu.dao;

import com.qdu.page.page;
import com.qdu.pojo.Message;

import java.util.List;

public interface MessageDao {
    List messageAll(int offset, int length);//获取所有留言
    void toMessage(String uid,String messageContent);//留言
    Message getMessageById();//根据messageid获取最新一条留言
    int getAllRowCount();//计算分页
    void thumbMessage(int messageId);//点赞留言
}
