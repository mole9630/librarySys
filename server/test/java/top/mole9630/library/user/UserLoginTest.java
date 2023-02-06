package top.mole9630.library.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;
import top.mole9630.library.common.Result;
import top.mole9630.library.controller.UserController;
import top.mole9630.library.entity.User;

@SpringBootTest
@Slf4j
public class UserLoginTest {
    @Autowired
    private UserController userController;

    /**
     * 密码登录测试(手机号错误信息)
     */
    @Test
    void passwordLoginWrongPhone () {
        User user = new User();
        user.setPhone("0");
        user.setPassword("123456");
        Result<User> result = userController.login(null, user);
        if (result.getCode() == 0) {
            log.info("passwordLoginWrongPhone测试通过 | " + result.getMessage());
        } else {
            log.error("passwordLoginWrongPhone测试失败 | " + result.getMessage());
        }
    }

    /**
     * 密码登录测试(密码错误信息)
     */
    @Test
    void passwordLoginWrongPassword() {
        User user = new User();
        user.setPhone("9630");
        user.setPassword("0");
        Result<User> result = userController.login(null, user);
        if (result.getCode() == 0) {
            log.info("passwordLoginWrongPassword测试通过 | " + result.getMessage());
        } else {
            log.error("passwordLoginWrongPassword测试失败 | " + result.getMessage());
        }
    }

    /**
     * 密码登录测试(正确信息)
     */
    @Test
    void passwordLoginPass() {
        User user = new User();
        user.setPhone("9630");
        user.setPassword("123456");
        Result<User> result = userController.login(null, user);
        if (result.getCode() == 200) {
            log.info("passwordLoginPass测试通过 | " + result.getMessage());
        } else {
            log.error("passwordLoginPass测试失败 | " + result.getMessage());
        }
    }
}
