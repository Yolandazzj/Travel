package com.qdu.service;


import com.qdu.dao.UserInfoDao;
import com.qdu.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {

     @Autowired
     private UserInfoDao userInfoDao;

    @Override
    public Userinfo validateUser(String uid, String upwd) {

        Userinfo user=userInfoDao.getUserById(uid);

        if(null!=user&&user.getUpassword().equals(upwd))
            return user;

        else
            return null;
    }

    @Override
    public void add(Userinfo userInfo) {

    }

    @Override
    public void update(Userinfo userInfo) {

    }

    @Override
    public List getUserInfoList() {
        return null;
    }
}
