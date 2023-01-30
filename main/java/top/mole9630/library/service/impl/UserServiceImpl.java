package top.mole9630.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.mole9630.library.entity.User;
import top.mole9630.library.mapper.UserMapper;
import top.mole9630.library.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
