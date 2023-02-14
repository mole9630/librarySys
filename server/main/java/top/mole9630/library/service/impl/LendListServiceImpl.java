package top.mole9630.library.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.entity.LendList;
import top.mole9630.library.mapper.LendListMapper;
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.LendListService;

import java.time.LocalDateTime;

@Service
public class LendListServiceImpl extends ServiceImpl<LendListMapper, LendList> implements LendListService {
    @Autowired
    private BookAllService bookAllService;

    @Override
    public void lendBook(Integer barcode, Integer userId) {
        // 拼接借阅信息
        LendList lendList = new LendList();
        lendList.setUserId(userId);
        lendList.setBookId(barcode);
        lendList.setLendDate(String.valueOf(LocalDateTime.now()));
        lendList.setRenewal(0);

        BookAll bookAll = new BookAll();
        bookAll.setId(barcode);
        bookAll.setLendStatus(0);
        this.save(lendList);
        bookAllService.updateById(bookAll);
    }
}
