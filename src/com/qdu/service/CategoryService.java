package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.Foodinfo;

import java.util.List;

public interface CategoryService {
    List categoryList();//获取美食类别表
    //List<Foodinfo> foodCateList(int fcategoryId);//通过美食类别ID获取该类别的美食列表
    page queryForPage(int currentPage, int pageSize,int fcategoryId) ;//分页查询

}
