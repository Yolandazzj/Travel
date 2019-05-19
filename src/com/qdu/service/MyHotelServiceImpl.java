package com.qdu.service;

import com.qdu.dao.MyHotelDao;
import com.qdu.dao.OrderDao;
import com.qdu.page.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyHotelServiceImpl implements MyHotelService {
 @Autowired
 private MyHotelDao myHotelDao;
    //分页
    @Override
    public page queryForPage(int currentPage, int pageSize,String uid) {
        page page = new page();
        //总记录数
        int allRow =myHotelDao.getAllRowCount(uid);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = myHotelDao.myHotelAll(offset, pageSize,uid);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }
}
