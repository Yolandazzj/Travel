package com.qdu.service;

import com.qdu.page.page;

public interface MyHotelService {
    page queryForPage(int currentPage, int pageSize, String uid);//分页查询
}
