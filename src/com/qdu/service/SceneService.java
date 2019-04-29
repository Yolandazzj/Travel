package com.qdu.service;

import com.qdu.pojo.City;
import com.qdu.pojo.Province;
import com.qdu.pojo.Scene;
import com.qdu.page.page;

import java.util.List;

public interface SceneService {

    //获取热门景点；
    Scene hotScene1();
    Scene hotScene2();
    Scene hotScene3();
    Scene hotScene4();
    Scene hotScene5();
    Scene hotScene6();
    Scene hotScene7();
    Scene sceneDetails(int sceneId);//根据景点ID获取景点详细信息；
    List sceneList();//获取景点列表；
    List<City> cityDetails(int sceneId);//根据景点ID获取所在城市信息；
    List<Province> proNameByCity(int cityId);//根据城市ID获取所在省份；
    page queryForPage(int currentPage,int pageSize) ;//分页查询
    boolean thumb(int sceneId);//点赞景点
}
