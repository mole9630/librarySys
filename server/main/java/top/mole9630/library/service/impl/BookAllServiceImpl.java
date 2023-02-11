package top.mole9630.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.mapper.BookAllMapper;
import top.mole9630.library.service.BookAllService;

@Service
public class BookAllServiceImpl extends ServiceImpl<BookAllMapper, BookAll> implements BookAllService {
}
