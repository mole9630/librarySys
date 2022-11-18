package top.library.user.mapper;

import org.apache.ibatis.annotations.Param;
import top.library.user.pojo.User;

import java.util.List;

public interface UserMapper {
    // 登录功能
    User selectLogin(@Param("userPhone") String userPhone, @Param("userPassword") String userPassword);

    // 注册功能
    int insertRegister(User user);

    // 根据手机号查询用户
    User selectUserByPhone(String userPhone);
}
