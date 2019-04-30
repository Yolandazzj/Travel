package com.qdu.service;

import com.qdu.pojo.Foodinfo;

import java.util.List;

public interface FStoreService {

    List<Foodinfo> storeFoodList(int did);//根据店的ID获取店里的所有美食；
}
