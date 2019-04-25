package com.qdu.service;

import com.qdu.pojo.City;
import com.qdu.pojo.Scene;

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
    List<City> cityDetails(int sceneId);//根据景点ID获取所在城市信息；
}
