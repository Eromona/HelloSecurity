package cn.bugstack.service.impl;

import cn.bugstack.pojo.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userService.getUserInfo(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在：" + username);
        }
        String role = userInfo.getRole();
        List<GrantedAuthority>authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        return new User(userInfo.getUsername(), userInfo.getPassword(), authorities);
    }
}
