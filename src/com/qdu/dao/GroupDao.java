package com.qdu.dao;

import java.util.Date;
import java.util.List;

public interface GroupDao {

    void toGroup(int cityId, String gtime,float gprice,int gquatity,String gendTime,String gcontent,String uid,String contact);//组团游申请表单数据插入到group表中
    List groupAll(int offset,int length);//获取全部组团游列表，分页
    int getAllRowCount();//获取总行数
}
