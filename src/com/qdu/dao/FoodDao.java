package com.qdu.dao;

import com.qdu.pojo.*;

import java.util.List;

public interface FoodDao {

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
    List foodAll(int offset, int length);//分页查询,获取美食列表
    int getAllRowCount();//获取总行数
    void thumb_food(int fid);//点赞功能（美食)
    void thumb_comment(int fcommentId);//点赞功能（美食评论)
    void toFoodComment(int fid,String uid,String fcommentContent);//美食评论
    Foodcomment getFoodCommentById();//根据fcommentId获取最新评论
    void deleteFood(int fid);//管理员删除美食
}
