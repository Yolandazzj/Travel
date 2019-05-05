package com.qdu.service;

import com.qdu.page.page;

import java.util.List;

public interface SearchService {
    List searchEssay(String keyword);
    List searchHotel(String keyword);
    page queryForPage(int currentPage, int pageSize, String keyword);//分页查询模糊搜索路线
    page queryForPageByScore(int currentPage, int pageSize,String keyword);
}
