package com.qdu.service;

import com.qdu.pojo.City;

import java.util.List;

public interface CityService {

    boolean thumb_city(int cityId);//点赞城市
    List proList();//获取省份列表；
    List<City> getCityByPro(int provinceId);//通过省份ID获取城市列表；
}
