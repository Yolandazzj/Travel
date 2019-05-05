package com.qdu.service;

import com.qdu.dao.CityDao;
import com.qdu.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    //点赞功能（城市）
    @Override
    public boolean thumb_city(int cityId) {
        cityDao.thumb_city(cityId);
        return true;
    }

    @Override
    public List proList() {
        return cityDao.proList();
    }

    @Override
    public List<City> getCityByPro(int provinceId) {
        return cityDao.getCityByPro(provinceId);
    }
}
