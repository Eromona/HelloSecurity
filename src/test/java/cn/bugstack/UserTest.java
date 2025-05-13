package cn.bugstack;

import cn.bugstack.pojo.UserInfo;
import cn.bugstack.service.impl.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Resource
    private UserService userService;

    @Test
    void insert() {
        userService.insertUserInfo(new UserInfo(null, "test", "123456", "root"));
    }
}
