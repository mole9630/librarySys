package top.library.service.user;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.library.mapper.user.UserMapper;
import top.library.pojo.user.User;
import top.library.util.db.SqlSessionFactoryUtils;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

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
}
