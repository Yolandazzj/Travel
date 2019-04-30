package com.qdu.service;

import com.qdu.page.page;
import com.qdu.pojo.*;

import java.util.List;

public interface FoodService {

    //获取热门美食1-7
    Foodinfo hotFood1();
    Foodinfo hotFood2();
    Foodinfo hotFood3();
    Foodinfo hotFood4();
    Foodinfo hotFood5();
    Foodinfo hotFood6();
    Foodinfo hotFood7();
    Foodinfo foodDetails(int fid);//根据美食ID获取美食详细信息；
    List<Category> cateName(int fid);//根据美食ID获取类别名字；
    List<Foodstore> storeDetails(int fid);//根据美食ID获取店的详细信息；(fid -> Did ->Dname，DAddress);
    List<City> cityInfo(int fid);//根据美食ID获取所在城市的名字；（fid -> Did -> cityId -> cityName）;
    List<Foodcomment> foodComment(int fid);//根据美食ID获取评论；
    List foodList();//获取美食列表
    page queryForPage(int currentPage, int pageSize) ;//分页查询
    boolean thumb_food(int fid);//点赞美食
    boolean thumb_comment(int fcommentId);//点赞美食评论
}
