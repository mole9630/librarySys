package top.mole9630.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.mole9630.library.entity.BookInfo;
import top.mole9630.library.mapper.BookInfoMapper;
import top.mole9630.library.service.BookInfoService;

@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements BookInfoService {
}
