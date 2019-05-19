package com.qdu.dao;

import java.util.List;

public interface MyHotelDao {
    List myHotelAll(int offset, int length, String uid);//hotel订单
    int getAllRowCount(String uid);//订单的条数
}
