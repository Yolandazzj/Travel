package com.qdu.service;

import com.qdu.dao.SceneDao;
import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Province;
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
    public Scene sceneDetails(int sceneId) {
        return sceneDao.sceneDetails(sceneId);
    }

    @Override
    public List sceneList() {
        return sceneDao.sceneList();
    }

    @Override
    public List<City> cityDetails(int sceneId) {
        return sceneDao.cityDetails(sceneId);
    }

    @Override
    public List<Province> proNameByCity(int cityId) {
        return sceneDao.proNameByCity(cityId);
    }

    /**
     * 分页查询路线
     * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
     * */
    @SuppressWarnings("unchecked")
    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page=new page();
        //总记录数
        int allRow =sceneDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List sceneList = sceneDao.sceneAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(sceneList);
        return page;
    }

    //点赞功能（景点）
    @Override
    public boolean thumb(int sceneId) {
        sceneDao.thumb(sceneId);
        return true;
    }


    //管理员删除景点
    @Override
    public void deleteScene(int sceneId) {
        sceneDao.deleteScene(sceneId);
    }


}
