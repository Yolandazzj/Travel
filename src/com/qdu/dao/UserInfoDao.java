
package com.qdu.dao;

import com.qdu.pojo.Userinfo;
import java.util.List;


public interface UserInfoDao extends BaseDao<Userinfo> {

    Userinfo getUserById(String uid);//通过用户的登录id获取用户信息，返回UserInfo对象
    void insert(Userinfo userInfo);//注册用户，添加用户
    void update(Userinfo userInfo);//修改用户信息
    List getUserInfoList();//获取用户信息的列表
    String checkName(String uid);
}
