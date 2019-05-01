package com.qdu.dao;

import com.qdu.pojo.Foodinfo;

import java.util.List;

public interface CategoryDao {
    List categoryList();//获取美食类别表
//    List<Foodinfo> foodCateList(int fcategoryId);//通过美食类别ID获取该类别的美食列表
    List foodCateAll(int offset, int length,int fcategoryId);//分页查询,获取该类别的美食列表
    int getAllRowCount(int fcategoryId);//获取总行数
}
