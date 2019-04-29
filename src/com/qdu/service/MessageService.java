package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.Message;

import java.util.List;

public interface MessageService {
//    List messageAll();//获取所有留言
    void toMessage(String uid,String messageContent);//留言
    Message getMessageById();//获取最新留言
    page queryForPage(int currentPage, int pageSize);//分页
    boolean thumbMessage(int messageId);
}
