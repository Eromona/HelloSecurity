package cn.bugstack.controller;

import cn.bugstack.pojo.UserInfo;
import cn.bugstack.service.impl.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    /*@GetMapping("/get")
    public UserInfo getUser(@RequestParam String username) {
        return userService.getUserInfo(username);
    }*/
}
