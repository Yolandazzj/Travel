package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Essay;
import com.qdu.pojo.Essaycomment;

import java.util.List;

public interface EssayService {
    List essayByScore(int cityId);//根据点赞数排序
    List essayByTime(int cityId);//根据时间排序
    boolean reportUser(String uid);//举报用户功能
    List getCityList();//获取所有城市
    page queryForPage(int currentPage, int pageSize) ;//分页查询
    void toEssay(String eTitle,String uid, String eContent,int cityId );//用户写帖子
    Essay essayDetails(int essayId);//根据游记ID获取游记详细信息；
    List<City> cityInfo(int essayId);//根据游记ID获取所在城市的名字；
    List<Essaycomment> essayComment(int essayId);//根据游记ID获取评论；
}
