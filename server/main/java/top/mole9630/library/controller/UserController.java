package top.mole9630.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import top.mole9630.library.common.Result;
import top.mole9630.library.entity.User;
import top.mole9630.library.service.UserService;
import top.mole9630.library.utils.ValidateCodeUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
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
    @ApiOperation(value = "发送手机验证码")
    @DynamicParameters(name = "用户信息", properties = {
            @DynamicParameter(value = "手机号", name = "phone", dataTypeClass = String.class, required = true, example = "138123456789")
    })
    public Result<String> sendMsg(@RequestBody User user) {
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
            String key = "PhoneCAPTCHA_" + phone;
            redisTemplate.opsForValue().set(key, code, 300, TimeUnit.SECONDS);
            return Result.success("验证码发送成功");
        }
        return Result.error(0, "验证码发送失败");
    }

    /**
     * 用户注册
     * @param user 用户对象
     * @param phoneCAPTCHA 手机验证码
     * @return 结果
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result<User> register(@RequestBody User user, String phoneCAPTCHA) {
        // 获取手机号
        String phone = user.getPhone();
        // 从redis中获取验证码
        String key = "PhoneCAPTCHA_" + phone;
        String redisCode = (String) redisTemplate.opsForValue().get(key);

        // 判断验证码是否正确
        if (StringUtils.isEmpty(phoneCAPTCHA) || !phoneCAPTCHA.equals(redisCode)) {
            return Result.error(0, "手机验证码错误, 请重新输入");
        }

        // 判断手机号是否已经注册
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, phone);
        User u = userService.getOne(queryWrapper);
        if (u != null) {
            return Result.error(0, "该手机号已经注册, 请重新输入");
        }

        // 将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 将加密后的密码设置到user对象中并初始化相关值
        user.setPassword(password);
        user.setDeposit(0);
        user.setMoney(0);
        user.setStatus(1);

        // 如果注册成功, 将验证码从redis中删除
        redisTemplate.delete(phone);

        // 将用户信息保存到数据库中
        userService.save(user);

        // 返回注册成功结果
        return Result.success(user, "注册成功");
    }

    /**
     * 用户登录
     * @param request 请求对象
     * @param user 用户对象(主要接收手机号和密码参数)
     * @return 结果
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
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
            return Result.error(0, "手机号错误, 请重新输入");
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
        HttpSession session = request.getSession();
        session.setAttribute("user", u);
        session.setMaxInactiveInterval(86400); // 1天
        return Result.success(u);
    }

    /**
     * 用户短信验证码登录
     * @param session session
     * @param map 接受手机号和验证码参数
     * @return 结果
     */
    @PostMapping("/codeMsgLogin")
    @ApiOperation(value = "用户短信验证码登录")
    public Result<User> codeMsgLogin(HttpServletRequest request, @RequestBody Map map) {
        // 获取手机号
        String phone = map.get("phone").toString();
        // 获取验证码
        String code = map.get("code").toString();
        // 获取session中的验证码
//        Object codeInSession = session.getAttribute(phone);
        // 获取redis中的验证码
        String key = "PhoneCAPTCHA_" + phone;
        Object codeInRedis = redisTemplate.opsForValue().get(key);
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
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(86400); // 1天

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
    @ApiOperation(value = "用户退出登录")
    public Result<String> logout(HttpServletRequest request) {
        // 1.清理Session中保存的当前登录的用户id
        request.getSession().removeAttribute("user");
        return Result.success("退出成功");
    }

    /**
     * 修改密码
     * @param user 用户对象
     * @return 修改密码结果
     */
    @PutMapping("/update-password")
    public Result<String> updatePassword(@RequestBody User user) {
        // 根据id查询用户
        User u = userService.getById(user.getId());
        // 将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 将页面提交的密码设置到查询到的用户对象中
        u.setPassword(password);
        // 更新用户
        boolean flag = userService.updateById(u);
        if (!flag) {
            return Result.error(0, "用户资料修改失败");
        }
        return Result.success("用户资料修改成功");
    }

/**
     * 修改用户资料
     * @param user 用户对象
     * @return 修改用户资料结果
     */
    @PutMapping("/update-info")
    public Result<String> updateInfo(@RequestBody User user) {
        // 更新用户
        boolean flag = userService.updateById(user);
        if (!flag) {
            return Result.error(0, "用户资料修改失败");
        }
        return Result.success("用户资料修改成功");
    }

    /**
     * 获取用户身份(二维)码
     * @param request 请求
     * @param response 响应
     * @return 用户身份(二维)码
     */
    @GetMapping("/getIdentityCode")
    public Result<String> getIdentityCode(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String identityCode = null;
        User user = (User) request.getSession().getAttribute("user");

        // 判断session中是否有user对象
        if (user == null) {
            return Result.error(0, "登录态失效, 请重新登录");
        }

        // 获取cookie中的identityCode
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("identityCode")) {
                identityCode = cookie.getValue();
            }
        }

        // 拼凑key并取出user对象
        String key = "user:identityCode:" + identityCode;

        // 判断cookie内是否有身份码
        if (identityCode != null) {
            // 如果cookie中已经存在该key, 则直接返回identityCode
            if (redisTemplate.opsForValue().get(key) != null) {
                // 如果redis中已经存在该key, 则直接返回identityCode
                return Result.success(identityCode);
            } else {
                // 如果不存在重新生成身份码
                identityCode = UUID.randomUUID().toString().replace("-", "");
                // 将identityCode存入redis
                redisTemplate.opsForValue().set(key, user.getId(), 60, TimeUnit.SECONDS);
                // 将identityCode存入cookie
                Cookie cookie = new Cookie("identityCode", identityCode);
                cookie.setMaxAge(60);
                return Result.success(identityCode);
            }
        } else {
            // 如果不存在重新生成身份码
            identityCode = UUID.randomUUID().toString().replace("-", "");
            // 将identityCode存入redis
            key = "user:identityCode:" + identityCode;
            redisTemplate.opsForValue().set(key, user.getId(), 60, TimeUnit.SECONDS);
            // 将identityCode存入cookie
            Cookie cookie = new Cookie("identityCode", identityCode);
            cookie.setMaxAge(60);
            return Result.success(identityCode);
        }
    }
}
