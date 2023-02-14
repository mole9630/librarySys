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
public class UserUpdateTest {
    @Autowired
    private UserController userController;

    /**
     * 修改用户信息
     */
    @Test
    void updateUserInfo() {
        User user = new User();
        user.setId(1);
        user.setSex(0);
        user.setBirthday("2023-01-01");
        Result<String> result = userController.updateInfo(user);
        log.info("修改结果:{}", result);
    }
}
