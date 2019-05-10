package com.qdu.service;

import com.qdu.dao.RouteDao;
import com.qdu.page.page;
import com.qdu.pojo.Agency;
import com.qdu.pojo.City;
import com.qdu.pojo.Route;
import com.qdu.pojo.Routecomment;
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

    @Override
    public List<Routecomment> routeComment(int routeId) {


        return routeDao.routeComment(routeId);
    }

    @Override
    public List<City> cityNameById(int cityId) {

        return routeDao.cityNameById(cityId);
    }

    @Override
    public List<City> hotCity() {
     return   routeDao.hotCity();
    }

    //根据城市分页查询路线
    @Override
    public page queryForPageCity(int currentPage, int pageSize, int cityId) {
        page page = new page();
        //总记录数
        int allRow =routeDao.getAllRowCountByCity(cityId);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = routeDao.cityForRoute(cityId,offset,pageSize);


        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }
    //根据城市id和好评度分页查询路线
    @Override
    public page queryForPageByCityScore(int currentPage, int pageSize,int cityId) {
        page page = new page();
        //总记录数
        int allRow =routeDao.getAllRowCountByCityScore(cityId);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = routeDao.searchRouteCityScore(cityId,offset,pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }

    //根据关键字和价格分页查询路线
    @Override
    public page queryForPageByCityPrice1(int currentPage, int pageSize,int cityId) {
        page page = new page();
        //总记录数
        int allRow =routeDao.getAllRowCountByCityPrice1(cityId);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = routeDao.searchCityRouteByPrice1(cityId,offset,pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }

    //根据关键字和价格分页查询路线
    @Override
    public page queryForPageByCityPrice2(int currentPage, int pageSize,int cityId) {
        page page = new page();
        //总记录数
        int allRow =routeDao.getAllRowCountByCityPrice2(cityId);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = routeDao.searchCityRouteByPrice2(cityId,offset,pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }

    //根据关键字和价格分页查询路线
    @Override
    public page queryForPageByCityPrice3(int currentPage, int pageSize,int cityId) {
        page page = new page();
        //总记录数
        int allRow =routeDao.getAllRowCountByPrice3(cityId);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = routeDao.searchRouteByCityPrice3(cityId,offset,pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }
//首页热门路线
    @Override
    public List indexHotRoute() {
        return routeDao.indexHotRoute();
    }

    //超值路线
    @Override
    public List lowerPriceRoute() {

        return routeDao.lowerRoute();
    }

    @Override
    public void toComment(String uid, String routecomments,int routeId) {
        routeDao.toComment(uid,routecomments,routeId);
    }

    @Override
    public Routecomment getCommentById() {
        return routeDao.getCommentById();
    }

}
