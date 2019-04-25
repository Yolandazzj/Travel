package com.qdu.service;

import com.qdu.dao.SceneDao;
import com.qdu.pojo.City;
import com.qdu.pojo.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneDao sceneDao;

    @Override
    public Scene hotScene1() {
        return sceneDao.hotScene1();
    }

    @Override
    public Scene hotScene2() {
        return sceneDao.hotScene2();
    }

    @Override
    public Scene hotScene3() {
        return sceneDao.hotScene3();
    }

    @Override
    public Scene hotScene4() {
        return sceneDao.hotScene4();
    }

    @Override
    public Scene hotScene5() {
        return sceneDao.hotScene5();
    }

    @Override
    public Scene hotScene6() {
        return sceneDao.hotScene6();
    }

    @Override
    public Scene hotScene7() {
        return sceneDao.hotScene7();
    }

    @Override
    public List<City> cityDetails(int sceneId) {
        return sceneDao.cityDetails(sceneId);
    }


}
