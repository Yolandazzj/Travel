package com.qdu.service;


import com.qdu.pojo.Userinfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Override
    public Userinfo validateUser(String uid, String upwd) {
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
