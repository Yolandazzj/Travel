package com.qdu.service;

import com.qdu.page.page;

public interface AdminManageService {
    page queryForPage(int currentPage, int pageSize);//分页查询
    void deleteOrder(int orderId);//删除订单
}
