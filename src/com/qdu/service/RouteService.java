package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.*;

import java.util.List;

public interface RouteService {
    Route hotRoute1();//热门路线1
    Route hotRoute2();//热门路线2
    Route hotRoute3();//热门路线3
    Route hotRoute4();//热门路线4
    Route hotRoute5();//热门路线5
    Route hotRoute6();//热门路线6
    Route hotRoute7();//热门路线7
    Route routeDetails(int routeId);//根据routeid获取路线详细信息
    List<Agency> agencyDetails(int routeId);//根据routeid获取旅行社信息;
    List<Routecomment> routeComment(int routeId);//根据routeId获取评论
    List<City> cityNameById(int cityId);//根据城市id获取城市名字
    List<City> hotCity();//查询热门城市
    page queryForPageCity(int currentPage, int pageSize, int cityId);//分页查询城市下面的路线
    page queryForPageByCityScore(int currentPage, int pageSize,int cityId);//分页并且按照评分排序城市下面的路线
    page queryForPageByCityPrice1(int currentPage, int pageSize,int cityId);
    page queryForPageByCityPrice2(int currentPage, int pageSize,int cityId);
    page queryForPageByCityPrice3(int currentPage, int pageSize,int cityId);
    List indexHotRoute();//首页热门路线
    List lowerPriceRoute();//超值路线
    void toComment(String uid,String routecomments,int routeId);//留言
    Routecomment getCommentById();//获取最新留言
    boolean thumb_route(int routeId);//点赞路线
}
