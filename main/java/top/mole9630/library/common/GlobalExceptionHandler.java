package top.mole9630.library.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.mole9630.library.exception.BusinessException;
import top.mole9630.library.exception.SystemException;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理类
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class}) // 拦截指定注解的类
@ResponseBody // 返回json数据
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 拦截SQLIntegrityConstraintViolationException异常
     * @param e 异常
     * @return R
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class) // 拦截指定异常
    public Result<String> exceptionHandler(SQLIntegrityConstraintViolationException e) {
        log.error("系统异常: {}", e.getMessage());
        // 判断异常信息中是否包含外键约束
        if (e.getMessage().contains("Duplicate entry")) {
            String[] split = e.getMessage().split(" ");
            return Result.error(0, "已存在:" + split[2] + ", 请更换名称后重试");
        }
        return Result.error(0 ,"未知错误, 请联系管理员");
    }

    @ExceptionHandler(CustomException.class) // 拦截指定异常
    public Result<String> exceptionHandler(CustomException e) {
//        log.error("业务异常: {}", e.getMessage());
        return Result.error(0, e.getMessage());
    }



    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e) {
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员,e对象一并发送
        // 返回给前端
        System.out.println("发送异常通知");
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e) {
        // 返回给前端
        System.out.println("发送异常通知");
        return Result.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        // 记录日志
        // 发送消息给运维
        // 发送邮件给开发人员,e对象一并发送
        // 返回给前端
        System.out.println("发送异常通知");
        return Result.error(Code.SYSTEM_UNKNOWN_ERROR, "系统繁忙, 请稍后再试");
    }
}
