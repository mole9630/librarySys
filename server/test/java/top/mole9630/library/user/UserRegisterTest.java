package top.mole9630.library.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import top.mole9630.library.common.Result;
import top.mole9630.library.controller.UserController;
import top.mole9630.library.entity.User;

/**
 * 用户注册测试类
 */
@SpringBootTest
@Slf4j
public class UserRegisterTest {
    @Autowired
    private UserController userController;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 用户注册测试
     */
    @Test
    void register() {
        User user = new User();
        user.setPhone("9630");
        user.setPassword("123456");
        user.setBirthday("2023-01-01");
        user.setIdentificationNumber("123456789012345678");
        user.setSex(1);
        user.setEmail("me@mole9630.top");
        user.setAddress("翻斗大街翻斗花园二号楼1001室");
        // 发送验证码
        userController.sendMsg(user);
        // 获取验证码
        String key = "PhoneCAPTCHA_" + user.getPhone();
        String code = (String) redisTemplate.opsForValue().get(key);
        // 注册操作
        Result<User> result = userController.register(user, code);
        log.info("注册结果:{}", result);
    }

    /**
     * 用户注册测试(重复的手机号)
     */
    @Test
    void registerWrongPhone() {
        User user = new User();
        user.setPhone("9630");
        user.setPassword("123321");
        user.setBirthday("2022-01-01");
        user.setIdentificationNumber("123456789012345678");
        user.setSex(1);
        user.setEmail("me@mole9630.top");
        user.setAddress("翻斗大街翻斗花园二号楼1002室");
        // 发送验证码
        userController.sendMsg(user);
        // 获取验证码
        String key = "PhoneCAPTCHA_" + user.getPhone();
        String code = (String) redisTemplate.opsForValue().get(key);
        // 注册操作
        Result<User> result = userController.register(user, code);
        log.info("注册结果:{}", result);
    }
}
