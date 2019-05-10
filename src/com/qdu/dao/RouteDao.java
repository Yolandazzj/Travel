package com.qdu.dao;

import com.qdu.pojo.*;

import java.util.List;

public interface RouteDao {
    Route hotRoute1();//获取热门路线1
    Route hotRoute2();//获取热门路线2
    Route hotRoute3();//获取热门路线3
    Route hotRoute4();//获取热门路线4
    Route hotRoute5();//获取热门路线5
    Route hotRoute6();//获取热门路线6
    Route hotRoute7();//获取热门路线7
    Route routeDeatils(int routeId);//根据路线id获取详细信息
    List<Agency> agencyDetails(int routeId);//根据路线id获取旅行社信息
    List<Routecomment> routeComment(int routeId);//根据id获取路线评论
    List<City> cityNameById(int cityId);//根据城市id获取城市名字
    List<City> hotCity();//查看热门城市
    List cityForRoute(int cityId,int offset, int length);//查看城市下面的路线
    int getAllRowCountByCity(int cityId);//城市下面的路线结果集条数
    List searchRouteCityScore(int cityId,int offset, int length);//根据评分排序城市下面的路线
    int getAllRowCountByCityScore(int cityId);//根据评分排序城市下面的路线结果集条数
    List searchCityRouteByPrice1(int cityId,int offset, int length);//根据价格分类城市下面的路线
    int getAllRowCountByCityPrice1(int cityId);//根据价格分类城市下面的路线结果集
    List searchCityRouteByPrice2(int cityId,int offset, int length);
    int getAllRowCountByCityPrice2(int cityId);
    List searchRouteByCityPrice3(int cityId,int offset, int length);
    int getAllRowCountByPrice3(int cityId);
    List indexHotRoute();//首页热门路线
    List lowerRoute();//超值路线
    void toComment(String uid,String routecomments,int routeId);//写评论
    Routecomment getCommentById();//根据id获取最新一条评论
}
