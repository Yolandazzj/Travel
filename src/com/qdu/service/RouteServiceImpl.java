package com.qdu.service;

import com.qdu.dao.RouteDao;
import com.qdu.pojo.Agency;
import com.qdu.pojo.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Service
public class RouteServiceImpl implements RouteService {

     @Autowired
      private RouteDao routeDao;

    @Override
    public Route hotRoute1() {

        return routeDao.hotRoute1();
    }

    @Override
    public Route hotRoute2() {
        return routeDao.hotRoute2();
    }

    @Override
    public Route hotRoute3() {
        return routeDao.hotRoute3();
    }

    @Override
    public Route hotRoute4() {
        return routeDao.hotRoute4();
    }

    @Override
    public Route hotRoute5() {
        return routeDao.hotRoute5();
    }

    @Override
    public Route hotRoute6() {
        return routeDao.hotRoute6();
    }

    @Override
    public Route hotRoute7() {
        return routeDao.hotRoute7();
    }

    @Override
    public Route routeDetails(int routeId) {
       return routeDao.routeDeatils(routeId);
    }

    @Override
    public List<Agency> agencyDetails(int routeId) {

        return routeDao.agencyDetails(routeId);
    }
}
