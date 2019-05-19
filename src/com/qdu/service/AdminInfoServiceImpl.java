package com.qdu.service;

import com.qdu.dao.AdminInfoDao;
import com.qdu.page.page;
import com.qdu.pojo.Admininfo;
import com.qdu.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AdminInfoServiceImpl implements AdminInfoService{

    @Autowired
    private AdminInfoDao adminInfoDao;

    @Override
    public Admininfo validateAdmin(String adminId, String adminPassword) {
        Admininfo admin = adminInfoDao.getAdminById(adminId);
        System.out.println(admin.getAdminPassword());
        if(null!=admin&&admin.getAdminPassword().equals(adminPassword)){
            return admin;
        }
        return null;
    }

    @Override
    public Admininfo getAdminById(String adminId) {
        return adminInfoDao.getAdminById(adminId);
    }

    //管理游记
    @Override
    public List manageReport() {
        return  adminInfoDao.manageReport();
    }

    //举报游记的删除
    @Override
    public void delete(int essayId) {
        adminInfoDao.delete(essayId);
    }

    @Override
    public List<Userinfo> getReportUserList() {
        return adminInfoDao.getReportUserList();
    }

    //禁用用户
    @Override
    public boolean reportUser(String uid) {
        adminInfoDao.banUser(uid);
        return true;
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
        int allRow =adminInfoDao.getAllRowCount();
        //当前页开始记录为第几条
        int offset = page.countOffset(currentPage,pageSize);
        //分页查询结果集
        List hotelOrderList = adminInfoDao.hotelOrderAll(offset, pageSize);

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(hotelOrderList);
        return page;
    }

}
