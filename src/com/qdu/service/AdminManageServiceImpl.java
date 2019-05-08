package com.qdu.service;

import com.qdu.dao.AdminManageDao;
import com.qdu.page.page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManageServiceImpl implements AdminManageService {
    @Autowired
    private AdminManageDao adminManageDao;
    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page = new page();
        //总记录数
        int allRow =adminManageDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List list = adminManageDao.myOrderAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);

        return page;
    }

    //管理员删除订单
    @Override
    public void deleteOrder(int orderId) {
        adminManageDao.deleteOrder(orderId);
    }
}
