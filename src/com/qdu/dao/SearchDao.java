package com.qdu.dao;

import java.util.List;

public interface SearchDao {
    List searchEssay(String keyword);
    List searchRoute(String keyword,int offset, int length);
    List searchHotel(String keyword);
    int getAllRowCount(String keyword);
//    List searchScene(String keyword);
}
