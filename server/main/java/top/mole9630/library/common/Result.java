package top.mole9630.library.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回结果类, 服务端响应的数据最终都会封装成此对象
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    private Integer code; //状态码：200成功, 其它数字为失败

    private String message; // 错误前端显示信息

    private T data; // 数据

    private Map map = new HashMap(); //动态数据

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.message = "ok";
        result.code = Code.GLOBAL_SUCCESS;
        return result;
    }

    public static <T> Result<T> success(T object, String message) {
        Result<T> result = new Result<T>();
        result.code = Code.GLOBAL_SUCCESS;
        result.message = message;
        result.data = object;
        return result;
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result result = new Result();
        result.code = code;
        result.message = msg;
        return result;
    }

    public static <T> Result<T> error(Integer code, String msg, T object) {
        Result result = new Result();
        result.code = code;
        result.message = msg;
        result.data = object;
        return result;
    }

    public Result<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
}
