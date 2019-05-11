package com.qdu.dao;

import com.qdu.pojo.City;

import java.util.List;

public interface CityDao {

    void thumb_city(int cityId);//点赞功能(城市)
    List proList();//获取省份列表；
    List<City> getCityByPro(int provinceId);//通过省份ID获取城市列表；
    City getCityByCityId(int cityId);
}
