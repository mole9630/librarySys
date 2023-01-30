package top.mole9630.library.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mole9630.library.common.Result;
import top.mole9630.library.controller.UserController;
import top.mole9630.library.entity.User;

@SpringBootTest
public class UserLoginTest {
    @Autowired
    private UserController userController;

    /**
     * 密码登录测试(正确信息)
     */
    @Test
    void passwordLoginPass() {
        User user = new User();
        user.setPhone("1582616876");
        user.setPassword("123321");
        Result<User> result = userController.login(null, user);
        if (result.getCode() == 200) {
            System.out.println("passwordLoginPass测试通过");
        } else {
            System.out.println("passwordLoginPass测试失败 | " + result.getMessage());
        }
    }

    @Test
    void passwordLoginWrongPhone () {
        User user = new User();
        user.setPhone("0");
        user.setPassword("123321");
        Result<User> result = userController.login(null, user);
        if (result.getCode() == 200) {
            System.out.println("passwordLoginPass测试通过");
        } else {
            System.out.println("passwordLoginPass测试失败 | " + result);
        }
    }

    @Test
    void passwordLoginWrongPassword() {
        User user = new User();
        user.setPhone("1582616876");
        user.setPassword("0");
        Result<User> result = userController.login(null, user);
        if (result.getCode() == 200) {
            System.out.println("passwordLoginPass测试通过");
        } else {
            System.out.println("passwordLoginPass测试失败 | " + result);
        }
    }
}
