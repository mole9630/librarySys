package top.mole9630.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.mole9630.library.entity.LendList;

public interface LendListService extends IService<LendList> {
    @Transactional
    void lendBook(Integer barcode, Integer userId);
}
