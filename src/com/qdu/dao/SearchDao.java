package com.qdu.dao;

import java.util.List;

public interface SearchDao {
    List searchEssay(String keyword);
    List searchRoute(String keyword,int offset, int length);
    List searchHotel(String keyword);
    int getAllRowCount(String keyword);
    List searchRouteByScore(String keyword,int offset, int length);
    int getAllRowCountByScore(String keyword);
//    List searchRouteByNumber(String keyword,int offset, int length);
    List searchRouteByPrice1(String keyword,int offset, int length);
    int getAllRowCountByPrice1(String keyword);
    List searchRouteByPrice2(String keyword,int offset, int length);
    int getAllRowCountByPrice2(String keyword);
    List searchRouteByPrice3(String keyword,int offset, int length);
    int getAllRowCountByPrice3(String keyword);
//    List searchScene(String keyword);
}
