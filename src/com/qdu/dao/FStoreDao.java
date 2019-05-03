package com.qdu.dao;

import com.qdu.pojo.Foodinfo;

import java.util.List;

public interface FStoreDao {

    List<Foodinfo> storeFoodList(int did);//根据店的ID获取店里的所有美食；
}
