package top.mole9630.library.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("状态码")
public class Code {
    // 全局状态码
    @ApiModelProperty("全局成功状态码")
    public static final Integer GLOBAL_SUCCESS = 200;
    @ApiModelProperty("全局失败状态码(未定义的状态码)")
    public static final Integer GLOBAL_ERROR = -1;


    // 业务状态码
    // 用户登录
    public static final Integer SAVE_SUCCESS = 20011;
    public static final Integer DELETE_SUCCESS = 20021;
    public static final Integer UPDATE_SUCCESS = 20031;
    public static final Integer GET_SUCCESS = 20041;


    public static final Integer SAVE_ERROR = 20010;
    public static final Integer DELETE_ERROR = 20020;
    public static final Integer UPDATE_ERROR = 20030;
    public static final Integer GET_ERROR = 20040;


    public static final Integer SYSTEM_ERROR = 50001;
    public static final Integer SYSTEM_TIMEOUT_ERROR = 50002;
    public static final Integer BUSINESS_ERROR = 55001;

    public static final Integer SYSTEM_UNKNOWN_ERROR = 59999;
}
