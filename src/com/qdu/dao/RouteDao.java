package com.qdu.dao;

import com.qdu.pojo.Agency;
import com.qdu.pojo.City;
import com.qdu.pojo.Route;
import com.qdu.pojo.Routecomment;

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
}
