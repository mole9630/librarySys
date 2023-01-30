package top.mole9630.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mole9630.library.common.Result;
import top.mole9630.library.entity.User;
import top.mole9630.library.service.UserService;
import top.mole9630.library.utils.ValidateCodeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 发送手机验证码
     * @param user 用户对象(主要接收手机号参数)
     * @return 结果
     */
    @PostMapping("/sendLoginCodeMsg")
    public Result<String> sendMsg(HttpSession session, @RequestBody User user) {
        // 获取手机号
        String phone = user.getPhone();

        if (StringUtils.isNotEmpty(phone)) {
            // 生成随机的6位数验证码
            String code = ValidateCodeUtils.generateValidateCode(6).toString();
            log.info("手机号{}的验证码为:{} (5分钟内有效)", phone, code);

            // 调用短信服务发送验证码
//            SMSUtils.sendMessage("签名", "模板编码", phone, code);

            // 将验证码存入session
//            session.setAttribute(phone, code);
            // 将验证码存入redis中并设置有效期为5分钟
            redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
            return Result.success("验证码发送成功");
        }
        return Result.error(0, "验证码发送失败");
    }

    /**
     * 用户登录
     * @param request 请求对象
     * @param user 用户对象(主要接收手机号和密码参数)
     * @return 结果
     */
    @PostMapping("/login")
    public Result<User> login(HttpServletRequest request, @RequestBody User user) {
        // 1.将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 2.根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, user.getPhone());
        User u = userService.getOne(queryWrapper);

        // 3.如果没有查询到则返回登录失败结果
        if (u == null) {
            return Result.error(0, "用户名错误, 请重新输入");
        }

        // 4.密码比对, 如果不一致则返回登录失败结果
        if (!u.getPassword().equals(password)) {
            return Result.error(0, "密码错误, 请重新输入");
        }

        // 5.查看员工状态, 如果为已禁用状态, 则返回员工已禁用结果
        if (u.getStatus() == 0) {
            return Result.error(0, "账户已被禁用, 请联系管理员");
        }

        // 6.登录成功, 将员Iid存入Session并返回登录成功结果
        request.getSession().setAttribute("user", u.getId());
        return Result.success(u);
    }

    /**
     * 用户短信验证码登录
     * @param session session
     * @param map 接受手机号和验证码参数
     * @return 结果
     */
    @PostMapping("/codeMsgLogin")
    public Result<User> codeMsgLogin(HttpSession session,@RequestBody Map map) {
        // 获取手机号
        String phone = map.get("phone").toString();
        // 获取验证码
        String code = map.get("code").toString();
        // 获取session中的验证码
//        Object codeInSession = session.getAttribute(phone);
        // 获取redis中的验证码
        Object codeInRedis = redisTemplate.opsForValue().get(phone);
        // 进行验证码比对(提交的验证码 和 redis保存的验证码比对)
        if (codeInRedis != null && codeInRedis.equals(code)) {
            // 验证码正确,登录成功
            // 判断手机号是否为新用户, 若是自动完成注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                // 新用户, 自动完成注册
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());

            // 如果登录成功, 将验证码从redis中删除
            redisTemplate.delete(phone);

            return Result.success(user);
        }
        // 验证码错误, 登录失败
        return Result.error(0 ,"登录失败");
    }

    /**
     * 用户退出登录
     * @param request 请求
     * @return 退出登录结果
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        // 1.清理Session中保存的当前登录的用户id
        request.getSession().removeAttribute("user");
        return Result.success("退出成功");
    }
}
