package com.qdu.service;

import com.qdu.dao.EssayDao;
import com.qdu.page.page;
import com.qdu.pojo.City;
import com.qdu.pojo.Essay;
import com.qdu.pojo.Essaycomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class EssayServiceImpl implements EssayService {

    @Autowired
    private EssayDao essayDao;

    @Override
    public Essay hotEssay1() {
        return essayDao.hotEssay1();
    }

    @Override
    public Essay hotEssay2() {
        return essayDao.hotEssay2();
    }

    @Override
    public Essay hotEssay3() {
        return essayDao.hotEssay3();
    }

    @Override
    public Essay hotEssay4() {
        return essayDao.hotEssay4();
    }

    @Override
    public Essay hotEssay5() {
        return essayDao.hotEssay5();
    }

    @Override
    public Essay hotEssay6() {
        return essayDao.hotEssay6();
    }

    @Override
    public Essay hotEssay7() {
        return essayDao.hotEssay7();
    }

    @Override
    public List essayByScore(int cityId) {
        return essayDao.essayByScore(cityId);
    }

    @Override
    public List essayByTime(int cityId) {
        return essayDao.essayByTime(cityId);
    }

    @Override
    public boolean reportUser(String uid) {
        essayDao.reportUser(uid);
        return true;
    }

    @Override
    public List getCityList() {
        return essayDao.getCityList();
    }

    /**
     * 分页查询
     * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
     * */
    @SuppressWarnings("unchecked")
    @Override
    public page queryForPage(int currentPage, int pageSize) {
        page page=new page();
        //总记录数
        int allRow =essayDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List essayList = essayDao.essayAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(essayList);
        return page;
    }

    @Override
    public void toEssay(String eTitle, String uid, String eContent, int cityId) {
        essayDao.toEssay(eTitle,uid,eContent,cityId);
    }

    //获取游记详细信息
    @Override
    public Essay essayDetails(int essayId) {
        return essayDao.essayDetails(essayId);
    }

    @Override
    public List<City> cityInfo(int essayId) {
        return essayDao.cityInfo(essayId);
    }

    @Override
    public List<Essaycomment> essayComment(int essayId) {
        return essayDao.essayComment(essayId);
    }

    @Override
    public boolean thumb_essay(int essayId) {
        essayDao.thumb_essay(essayId);
        return true;
    }

    @Override
    public boolean thumb_comment(int eCommentId) {
        essayDao.thumb_comment(eCommentId);
        return true;
    }

    @Override
    public void toEssayComment(int essayId, String uid, String eCommentContent) {
        essayDao.toEssayComment(essayId,uid,eCommentContent);
    }

    @Override
    public Essaycomment getEssayCommentById() {
        return essayDao.getEssayCommentById();
    }

    @Override
    public List<Essay> getEssayMineList(String uid) {
        return essayDao.getEssayMineList(uid);
    }

    @Override
    public void deleteEssay(int essayId) {
       essayDao.deleteEssay(essayId);
    }


}
