package com.qdu.dao;

import java.util.List;

public interface AdminManageDao {
    List myOrderAll(int offset, int length);//查看用户所有订单
    int getAllRowCount();//所有订单的条数
    void deleteOrder(int orderId);//删除订单
}
