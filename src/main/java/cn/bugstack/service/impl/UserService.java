package cn.bugstack.service.impl;

import cn.bugstack.mapper.UserMapper;
import cn.bugstack.pojo.UserInfo;
import cn.bugstack.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo getUserInfo(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void insertUserInfo(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userMapper.insertUser(userInfo);
    }
}
