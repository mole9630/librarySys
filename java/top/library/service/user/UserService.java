package top.library.service.user;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.library.mapper.log.LogMapper;
import top.library.mapper.user.UserMapper;
import top.library.pojo.user.User;
import top.library.util.db.SqlSessionFactoryUtils;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录校验工作
     * @param userPhone 用户手机号
     * @param userPassword 用户密码
     * @return 返回用户信息
     */
    public User selectLogin(String userPhone, String userPassword) {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //执行方法
        User user = userMapper.selectLogin(userPhone, userPassword);
        // 释放资源
        sqlSession.close();

        return user;
    }

    /**
     * 注册时检验手机号是否已经被注册
     * @param userPhone 用户手机号
     * @return 返回已存在的用户信息/null
     */
    public User selectUserByPhone(String userPhone) {
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 判断手机号是否存在
        return userMapper.selectUserByPhone(userPhone);
    }

    public int insertRegister(User user) {
        int statusCode = -1;
        // 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取Mapper对象接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行方法
        statusCode = userMapper.insertRegister(user);
        sqlSession.commit();

        return statusCode;
    }

}
