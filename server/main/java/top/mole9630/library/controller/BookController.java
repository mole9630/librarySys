package top.mole9630.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mole9630.library.common.Result;
import top.mole9630.library.entity.BookInfo;
import top.mole9630.library.service.BookInfoService;

@RestController
@RequestMapping("/book")
@Api(tags = "图书信息相关接口")
public class BookController {
    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 分页查询图书信息
     * @param page 当前页
     * @param pageSize 每页显示条数
     * @param searchText 搜索内容
     * @param type 搜索类型
     * @return 图书信息
     */
    @GetMapping("/page")
    public Result<Page> searchBookInfoPage(int page, int pageSize, String searchText, Integer type) {
        // 构造分页构造器
        Page<BookInfo> bookInfoPage = new Page<>(page, pageSize);
        // 构造条件构造器
        LambdaQueryWrapper<BookInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 添加过滤条件
        if (type != null) {
            switch (type) {
                case 1: //按书名搜索
                    queryWrapper.like(StringUtils.isNotEmpty(searchText),BookInfo::getName, searchText);
                    break;
                case 2: //按ISBN搜索
                    queryWrapper.like(StringUtils.isNotEmpty(searchText),BookInfo::getIbsn, searchText);
                    break;
                case 3: //按作者搜索
                    queryWrapper.like(StringUtils.isNotEmpty(searchText),BookInfo::getAuthor, searchText);
                    break;
                case 4: //按出版社搜索
                    queryWrapper.like(StringUtils.isNotEmpty(searchText),BookInfo::getPublisher, searchText);
                    break;
                default:
                    return Result.error(0, "参数错误, 请稍后重试");
            }
        }
        // 添加排序条件
        queryWrapper.orderByDesc(BookInfo::getUpdate_time);
        // 查询
        bookInfoService.page(bookInfoPage, queryWrapper);
        return Result.success(bookInfoPage);
    }
}
