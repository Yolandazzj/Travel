package com.qdu.service;

import com.qdu.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
