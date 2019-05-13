package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Essay;
import com.qdu.pojo.Essaycomment;
import com.qdu.pojo.Foodcomment;

import java.util.List;

public interface EssayService {
    //获取热门攻略1-7
    Essay hotEssay1();
    Essay hotEssay2();
    Essay hotEssay3();
    Essay hotEssay4();
    Essay hotEssay5();
    Essay hotEssay6();
    Essay hotEssay7();
    List essayByScore(int cityId);//根据点赞数排序
    List essayByTime(int cityId);//根据时间排序
    boolean reportUser(String uid);//举报用户功能
    List getCityList();//获取所有城市
    page queryForPage(int currentPage, int pageSize) ;//分页查询
    void toEssay(String eTitle,String uid, String eContent,int cityId );//用户写帖子
    Essay essayDetails(int essayId);//根据游记ID获取游记详细信息；
    List<City> cityInfo(int essayId);//根据游记ID获取所在城市的名字；
    List<Essaycomment> essayComment(int essayId);//根据游记ID获取评论；
    boolean thumb_essay(int essayId);//点赞功能（游记)
    boolean thumb_comment(int eCommentId);//点赞功能（游记评论)
    void toEssayComment(int essayId,String uid,String eCommentContent);//发表游记评论
    Essaycomment getEssayCommentById();//根据eCommentId获取最新评论
    List<Essay> getEssayMineList(String uid);//获取我的游记
    void deleteEssay(int essayId);//删除游记

}
