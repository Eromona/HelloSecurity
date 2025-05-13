package cn.bugstack.service;

import cn.bugstack.pojo.UserInfo;

public interface IUserService {
    UserInfo getUserInfo(String username);

    void insertUserInfo(UserInfo userInfo);
}
