package com.qdu.service;

import com.qdu.dao.FoodDao;
import com.qdu.page.page;
import com.qdu.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodDao foodDao;

    //获取热门美食1-7
    @Override
    public Foodinfo hotFood1() {
        return foodDao.hotFood1();
    }

    @Override
    public Foodinfo hotFood2() {
        return foodDao.hotFood2();
    }

    @Override
    public Foodinfo hotFood3() {
        return foodDao.hotFood3();
    }

    @Override
    public Foodinfo hotFood4() {
        return foodDao.hotFood4();
    }

    @Override
    public Foodinfo hotFood5() {
        return foodDao.hotFood5();
    }

    @Override
    public Foodinfo hotFood6() {
        return foodDao.hotFood6();
    }

    @Override
    public Foodinfo hotFood7() {
        return foodDao.hotFood7();
    }

    //获取美食详细信息
    @Override
    public Foodinfo foodDetails(int fid) {
        return foodDao.foodDetails(fid);
    }

    //获取美食对应的类别名
    @Override
    public List<Category> cateName(int fid) {
        return foodDao.cateName(fid);
    }

    //获取美食对应的店的详细信息
    @Override
    public List<Foodstore> storeDetails(int fid) {
        return foodDao.storeDetails(fid);
    }

    //获取美食对应的店所在的城市名
    @Override
    public List<City> cityInfo(int fid) {
        return foodDao.cityInfo(fid);
    }

    @Override
    public List<Foodcomment> foodComment(int fid) {
        return foodDao.foodComment(fid);
    }

    //获取全部美食列表
    @Override
    public List foodList() {
        return foodDao.foodList();
    }

    //分页查询
    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page=new page();
        //总记录数
        int allRow =foodDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List foodList = foodDao.foodAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(foodList);
        return page;
    }

    //点赞功能（美食）
    @Override
    public boolean thumb_food(int fid) {
        foodDao.thumb_food(fid);
        return true;
    }

    @Override
    public boolean thumb_comment(int fcommentId) {
        foodDao.thumb_comment(fcommentId);
        return true;
    }

    @Override
    public void toFoodComment(int fid, String uid, String fcommentContent) {
        foodDao.toFoodComment(fid,uid,fcommentContent);
    }

    @Override
    public Foodcomment getFoodCommentById() {
        return foodDao.getFoodCommentById();
    }
}
