package top.mole9630.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.mole9630.library.entity.LendList;
import top.mole9630.library.mapper.LendListMapper;
import top.mole9630.library.service.LendListService;

@Service
public class LendListServiceImpl extends ServiceImpl<LendListMapper, LendList> implements LendListService {
}
