package com.qdu.service;

import com.qdu.page.page;

import java.util.Date;

public interface GroupService {

    void toGroup(int cityId, String gtime,float gprice,int gquatity,String gendTime,String gcontent,String uid,String contact);//组团游申请表单数据插入到group表中
    page queryForPage(int currentPage, int pageSize) ;//分页查询
    boolean approve_group(int gid);//管理员批准组团游
}
