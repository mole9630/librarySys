package top.mole9630.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.mole9630.library.entity.LendList;

public interface LendListService extends IService<LendList> {
    /**
     * 借阅图书
     * @param barcode 图书条形码
     * @param userId 用户id
     */
    @Transactional
    void lendBook(Integer barcode, Integer userId);

    /**
     * 归还图书
     * @param userId 用户id
     * @param barcode 图书条形码
     * @param code 借阅单号
     */
    @Transactional
    void backBook(Integer userId, Integer barcode, String code);
}
