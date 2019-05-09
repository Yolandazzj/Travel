package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.Essay;

import java.util.List;

public interface EssayService {
    List essayByScore(int cityId);//根据点赞数排序
    List essayByTime(int cityId);//根据时间排序
    boolean reportUser(String uid);//举报用户功能
    List getCityList();//获取所有城市
    page queryForPage(int currentPage, int pageSize) ;//分页查询
    void toEssay(String eTitle,String uid, String eContent,int cityId );//用户写帖子
}
