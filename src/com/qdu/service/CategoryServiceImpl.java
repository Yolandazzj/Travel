package com.qdu.service;

import com.qdu.dao.CategoryDao;
import com.qdu.page.page;
import com.qdu.pojo.Foodinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List categoryList() {
        return categoryDao.categoryList();
    }



    //分页查询
    @Override
    public page queryForPage(int currentPage, int pageSize,int fcategoryId) {
        page page=new page();
        //总记录数
        int allRow =categoryDao.getAllRowCount(fcategoryId);
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List foodCateList = categoryDao.foodCateAll(offset,pageSize,fcategoryId);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(foodCateList);
        return page;
    }

//    获取该类别下的美食列表
//    @Override
//    public List<Foodinfo> foodCateList(int fcategoryId) {
//        return categoryDao.foodCateList(fcategoryId);
//    }
}
