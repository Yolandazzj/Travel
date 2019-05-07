package com.qdu.dao;

import java.util.Date;
import java.util.List;

public interface GroupDao {

    void toGroup(int cityId, String gtime,float gprice,int gquatity,String gendTime,String gcontent,String uid,String contact);//组团游申请表单数据插入到group表中
    List groupAll(int offset,int length);//获取全部未批准组团游列表，分页
    int getAllRowCount();//获取未批准组团游总行数
    List groupApproved(int offset, int length);//获取全部已批准组团游列表，分页
    int getApprovedRowCount();//获取已批准组团游总行数
    void approve_group(int gid);//管理员批准组团游
    void disapprove_group(int gid);//管理员不批准组团游
}
