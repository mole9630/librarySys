package top.library.mapper.user;

import org.apache.ibatis.annotations.Param;
import top.library.pojo.user.User;

public interface UserMapper {
    // 登录功能
    User selectLogin(@Param("userPhone") String userPhone, @Param("userPassword") String userPassword);

    // 注册功能
    int insertRegister(User user);

    // 根据手机号查询用户
    User selectUserByPhone(String userPhone);
}
