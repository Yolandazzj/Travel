package com.qdu.dao;


import com.qdu.pojo.City;
import com.qdu.pojo.Province;
import com.qdu.pojo.Scene;

import java.util.List;

public interface SceneDao {

    //获取热门景点1-7；
    Scene hotScene1();
    Scene hotScene2();
    Scene hotScene3();
    Scene hotScene4();
    Scene hotScene5();
    Scene hotScene6();
    Scene hotScene7();
    Scene sceneDetails(int sceneId);//根据景点ID获取景点详细信息；
    List<City> cityDetails(int sceneId);//根据景点ID获取所在城市名字；
    List<Province> proNameByCity(int cityId);//根据城市ID获取所在省份；
    List queryForPage(int offset, int length,int uid);//分页查询
    int getAllRowCount(int sceneId);//获取总行数
    void thumb(int sceneId);//点赞功能
}
