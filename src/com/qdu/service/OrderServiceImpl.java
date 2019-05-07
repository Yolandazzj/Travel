package com.qdu.service;

import com.qdu.dao.OrderDao;
import com.qdu.page.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
 @Autowired
 private OrderDao orderDao;
    @Override
    public void toOrder(int routeId, int routeOrderPeople, String routeName, String uid, String routeOrderName, float routePrice, String contact) {
       orderDao.toOrder(routeId,routeOrderPeople,routeName,uid,routeOrderName,routePrice,contact);
    }


    //分页
    @Override
    public page queryForPage(int currentPage, int pageSize,String uid) {
        page page = new page();
        //总记录数
        int allRow =orderDao.getAllRowCount(uid);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = orderDao.myOrderAll(offset, pageSize,uid);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }
}
