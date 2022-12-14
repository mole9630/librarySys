package top.library.service.log;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.library.mapper.log.LogMapper;
import top.library.pojo.log.Log;
import top.library.pojo.user.User;
import top.library.util.db.SqlSessionFactoryUtils;
import top.library.util.log.GetTimestampUtils;

/**
 * @author mole9630
 */
public class LogService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    private GetTimestampUtils getTimestampUtils = new GetTimestampUtils();

    /**
     * 添加登录日志
     * @param user 用户信息
     */
    public void insertLoginLog(User user) {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        //执行方法
        Log log = new Log();
        log.setuCardId(user.getuCardId());
        log.setlStartTime(getTimestampUtils.getTimestamp());
        log.setlEndTime(getTimestampUtils.getTimestamp());
        log.setlType("user.login");
        logMapper.insertLog(log);
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    /**
     * 添加注册日志
     * @param user 用户信息
     */
    public void insertRegisterLog(User user) {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        // 写入注册日志
        Log log = new Log();
        log.setuCardId(user.getuCardId());
        log.setlStartTime(getTimestampUtils.getTimestamp());
        log.setlEndTime(getTimestampUtils.getTimestamp());
        log.setlType("user.register");
        logMapper.insertLog(log);
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }
}
