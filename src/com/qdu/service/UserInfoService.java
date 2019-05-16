
package com.qdu.service;

import com.qdu.pojo.Userinfo;
import java.util.List;


public interface UserInfoService {
  Userinfo validateUser(String uid, String upwd);//验证用户登录
  void add(Userinfo userInfo);//注册新用户，添加用户
  void update(Userinfo userInfo);//修改用户信息
  List getUserInfoList();//存放用户信息的列表
  Userinfo getUserById(String uid );
  Userinfo checkName(String uid);

}
