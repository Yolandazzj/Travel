package com.qdu.service;

import com.qdu.page.page;

import java.util.Date;

public interface GroupService {

    void toGroup(int cityId, String gtime,float gprice,int gquatity,String gendTime,String gcontent,String uid,String contact);//组团游申请表单数据插入到group表中
    page queryForPage(int currentPage, int pageSize) ;//分页查询(全部未批准组团游)
    boolean approve_group(int gid);//管理员批准组团游
    boolean disapprove_group(int gid);//管理员不批准组团游
    page queryForPage2(int currentPage, int pageSize) ;//分页查询(全部已批准组团游)
}
