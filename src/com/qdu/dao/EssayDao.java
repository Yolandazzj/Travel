package com.qdu.dao;

import com.qdu.pojo.City;
import com.qdu.pojo.Essay;
import com.qdu.pojo.Essaycomment;

import java.util.List;

public interface EssayDao  {
    List essayByScore(int cityId);//根据点赞数排序
    List essayByTime(int cityId);//根据时间排序
    void reportUser(String uid);//用户举报功能
    List getCityList();//获取所有城市
    List queryForPage(int offset, int length,String uid);//分页查询
    int getAllRowCount();//获取总行数
    List essayAll(int offset, int length);//所有游记
    void toEssay(String eTitle,String uid, String eContent,int cityId );
    Essay essayDetails(int essayId);//根据游记ID获取游记详细信息；
    List<City> cityInfo(int essayId);//根据游记ID获取所在城市的名字；
    List<Essaycomment> essayComment(int essayId);//根据游记ID获取评论；
}
