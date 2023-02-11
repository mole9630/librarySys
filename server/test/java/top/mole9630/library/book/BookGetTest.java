package top.mole9630.library.book;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.mole9630.library.common.Result;
import top.mole9630.library.controller.BookController;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.entity.BookInfo;
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.BookInfoService;

import java.util.List;

@SpringBootTest
@Slf4j
public class BookGetTest {
    @Autowired
    private BookController bookController;

    /**
     * 分页查询图书信息
     * @return 图书信息
     */
    @Test
    void getSearchBookTest() {
        Result<Page> result = bookController.searchBookInfoPage(1, 10, "青少年", 1);
        log.info("result: {}", result);
    }

    @Test
    void getBookInfoTest() {
        Result<BookInfo> result = bookController.getBookInfo(15052);
        log.info("result: {}", result);
    }

    /**
     * 查询图书馆藏信息
     * @return 图书馆藏信息
     */
    @Test
    void getBookAllTest() {
        Result<List<BookAll>> result = bookController.getBookAll(15052);
        log.info("result: {}", result);
    }
}
