package top.mole9630.library.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.entity.LendList;
import top.mole9630.library.mapper.LendListMapper;
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.LendListService;
import top.mole9630.library.utils.OrderUtils;

import java.time.LocalDateTime;

@Service
public class LendListServiceImpl extends ServiceImpl<LendListMapper, LendList> implements LendListService {
    @Autowired
    private BookAllService bookAllService;

    /**
     * 借阅图书
     * @param barcode 图书条形码
     * @param userId 用户id
     */
    @Override
    public void lendBook(Integer userId, Integer barcode) {
        // 拼接借阅信息
        LendList lendList = new LendList();
        lendList.setCode(OrderUtils.getLendCode(userId).trim());
        lendList.setUserId(userId);
        lendList.setBookId(barcode);
        LocalDateTime nowDateTime = LocalDateTime.now();
        lendList.setLendDate(String.valueOf(nowDateTime));
        lendList.setBackDate(String.valueOf(nowDateTime.plusDays(30)));
        lendList.setBackStatus(0);
        lendList.setRenewal(0);
        this.save(lendList);

        // 拼接图书信息
        BookAll bookAll = new BookAll();
        bookAll.setId(barcode);
        bookAll.setLendStatus(0);
        bookAllService.updateById(bookAll);
    }

    /**
     * 归还图书
     * @param userId 用户id
     * @param barcode 图书条形码
     * @param code 借阅单号
     */
    @Override
    public void backBook(Integer userId, Integer barcode, String code) {
        // 拼接借阅信息
        LambdaUpdateWrapper<LendList> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(LendList::getCode, code);
        updateWrapper.set(LendList::getBackStatus, 1);
        this.update(updateWrapper);

        // 拼接图书信息
        BookAll bookAll = new BookAll();
        bookAll.setId(barcode);
        bookAll.setLendStatus(1);
        bookAllService.updateById(bookAll);
    }
}
