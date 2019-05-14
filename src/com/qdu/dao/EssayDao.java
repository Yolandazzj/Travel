package com.qdu.dao;

import com.qdu.pojo.City;
import com.qdu.pojo.Essay;
import com.qdu.pojo.Essaycomment;

import java.util.List;

public interface EssayDao  {
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
    void reportUser(String uid);//用户举报功能
    List getCityList();//获取所有城市
    List queryForPage(int offset, int length,String uid);//分页查询
    int getAllRowCount();//获取总行数
    List essayAll(int offset, int length);//所有游记
    void toEssay(String eTitle,String uid, String eContent,int cityId );
    Essay essayDetails(int essayId);//根据游记ID获取游记详细信息；
    List<City> cityInfo(int essayId);//根据游记ID获取所在城市的名字；
    List<Essaycomment> essayComment(int essayId);//根据游记ID获取评论；
    void thumb_essay(int essayId);//点赞功能（游记)
    void thumb_comment(int eCommentId);//点赞功能（游记评论)
    void toEssayComment(int essayId,String uid,String eCommentContent);//发表游记评论
    Essaycomment getEssayCommentById();//根据eCommentId获取最新评论
    List<Essay> getEssayMineList(String uid); //获取我的游记列表
    void deleteEssay(int essayId);
    List indexHotEssay();//首页显示热门游记;

}
