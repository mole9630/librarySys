package top.library.mapper.user;

import org.apache.ibatis.annotations.Param;
import top.library.pojo.user.User;

/**
 * @author mole9630
 */
public interface UserMapper {
    /**
     * 登录功能
     * @param userPhone 用户手机号
     * @param userPassword 用户密码
     * @return 返回用户对象
     */
    User selectLogin(@Param("userPhone") String userPhone, @Param("userPassword") String userPassword);

    /**
     * 注册功能
     * @param user 用户对象
     * @return 返回受影响的行数
     */
    int insertRegister(User user);

    /**
     * 根据手机号查询用户
     * @param userPhone 用户手机号
     * @return 返回用户对象
     */
    User selectUserByPhone(String userPhone);
}
