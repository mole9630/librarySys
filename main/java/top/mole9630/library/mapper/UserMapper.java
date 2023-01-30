package top.mole9630.library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.mole9630.library.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
