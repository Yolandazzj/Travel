package com.qdu.service;

import com.qdu.page.page;

import java.util.List;

public interface OrderService {
    void toOrder(int routeId,int routeOrderPeople,String routeName,String uid,String routeOrderName,float routePrice,String contact);//预定
    page queryForPage(int currentPage, int pageSize, String uid);//分页查询
}
