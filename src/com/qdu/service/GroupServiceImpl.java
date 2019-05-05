package com.qdu.service;

import com.qdu.dao.GroupDao;
import com.qdu.page.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;


    @Override
    public void toGroup(int cityId, String gtime, float gprice, int gquatity, String gendTime, String gcontent, String uid, String contact) {
        groupDao.toGroup(cityId,gtime,gprice,gquatity,gendTime,gcontent,uid,contact);
    }

    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page=new page();
        //总记录数
        int allRow =groupDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List groupList = groupDao.groupAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(groupList);
        return page;
    }
}
