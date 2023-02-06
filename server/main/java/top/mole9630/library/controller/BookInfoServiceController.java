package top.mole9630.library.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mole9630.library.common.Result;
import top.mole9630.library.service.BookInfoService;

@RestController
@RequestMapping("/book-info")
@Api(tags = "图书信息相关接口")
public class BookInfoServiceController {
    @Autowired
    private BookInfoService bookInfoService;

    public Result<Page> searchBookInfoPage(int page, int pageSize, String searchText, Integer type) {
        return null;
    }
}
