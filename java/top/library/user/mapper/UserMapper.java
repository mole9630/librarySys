package top.library.user.mapper;

import org.apache.ibatis.annotations.Param;
import top.library.user.pojo.User;

import java.util.List;

public interface UserMapper {
    User selectLogin(@Param("userPhone") String userPhone, @Param("userPassword") String userPassword);

    int insertRegister(User user);
}
