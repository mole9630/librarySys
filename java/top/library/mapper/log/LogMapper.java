package top.library.mapper.log;

import top.library.pojo.log.Log;

/**
 * @author mole9630
 */
public interface LogMapper {
    /**
     * 插入登录日志
     * @param log 日志信息
     */
    void insertLog(Log log);
}
