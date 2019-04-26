package com.qdu.service;

import com.qdu.dao.MessageDao;
import com.qdu.page.page;
import com.qdu.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

//    @Override
//    public List messageAll() {
//
//        return  messageDao.messageAll();
//    }

    @Override
    public void toMessage(String uid,String messageContent) {
        messageDao.toMessage(uid,messageContent);
    }


    //获取刚提交的评论
    @Override
    public Message getMessageById() {
        return messageDao.getMessageById();
    }

    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page = new page();
        //总记录数
        int allRow =messageDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = messageDao.messageAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }
}
