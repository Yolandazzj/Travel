package com.qdu.service;

import com.qdu.pojo.Agency;
import com.qdu.pojo.Route;

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
}
