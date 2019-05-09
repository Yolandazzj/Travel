package com.qdu.dao;

import com.qdu.pojo.Essay;

import java.util.List;

public interface EssayDao  {
    void insert(Essay essay);//用户写游记
    List essayByScore(int cityId);//根据点赞数排序
    List essayByTime(int cityId);//根据时间排序
    void reportUser(String uid);//用户举报功能
    List getCityList();//获取所有城市
    List queryForPage(int offset, int length,String uid);//分页查询
    int getAllRowCount();//获取总行数
    List essayAll(int offset,int length);
}
