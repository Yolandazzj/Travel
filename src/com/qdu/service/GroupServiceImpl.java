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


    //组团游申请表单数据插入到group表中
    @Override
    public void toGroup(int cityId, String gtime, float gprice, int gquatity, String gendTime, String gcontent, String uid, String contact) {
        groupDao.toGroup(cityId,gtime,gprice,gquatity,gendTime,gcontent,uid,contact);
    }

    //分页查询(全部未批准组团游)
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

    //管理员批准组团游
    @Override
    public boolean approve_group(int gid) {
        groupDao.approve_group(gid);
        return true;
    }


    //管理员不批准组团游
    @Override
    public boolean disapprove_group(int gid) {
        groupDao.disapprove_group(gid);
        return true;
    }


    //分页查询(全部已批准组团游)
    @Override
    public page queryForPage2(int currentPage, int pageSize) {
        page page2=new page();
        //总记录数
        int allRow =groupDao.getApprovedRowCount();
        //当前页开始记录为第几条
        int offset = page2.countOffset(currentPage,pageSize);
        //分页查询结果集
        List groupApprovedList = groupDao.groupApproved(offset, pageSize);

        page2.setPageNo(currentPage);
        page2.setPageSize(pageSize);
        page2.setTotalRecords(allRow);
        page2.setList(groupApprovedList);
        return page2;
    }
}
