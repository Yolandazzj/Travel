package com.qdu.dao;

import java.util.List;

public interface OrderDao {
    void toOrder(int routeId,int routeOrderPeople,String routeName,String uid,String routeOrderName,float routePrice,String contact);//预定
    List myOrderAll(int offset, int length,String uid);//查看我的所有订单
    int getAllRowCount(String uid);//所有订单的条数
}
