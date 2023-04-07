package top.mole9630.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mole9630.library.common.Result;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.entity.BookInfo;
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.BookInfoService;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(tags = "图书信息相关接口")
public class BookController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookAllService bookAllService;

    /**
     * 分页查询图书信息
     * @param page 当前页
     * @param pageSize 每页显示条数
     * @param searchText 搜索内容
     * @param type 搜索类型
     * @return 图书信息
     */
    @GetMapping("/search-book-page")
    @ApiOperation(value = "模糊检索图书信息")
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
//        queryWrapper.orderByDesc(BookInfo::getUpdate_time);
        // 查询
        bookInfoService.page(bookInfoPage, queryWrapper);
        return Result.success(bookInfoPage);
    }

    /**
     * 根据图书id查询单个图书详细信息
     * @param bookId 图书id
     * @return 图书详细信息
     */
    @GetMapping("/get-book-info")
    @ApiOperation(value = "查询图书详细信息")
    public Result<BookInfo> getBookInfo(Integer bookId) {
        BookInfo bookInfo = bookInfoService.getById(bookId);
        return Result.success(bookInfo);
    }

    /**
     * 根据图书id查询图书馆藏信息
     * @param bookId 图书id
     * @return 图书馆藏信息
     */
    @GetMapping("/get-book-all")
    @ApiOperation(value = "查询图书馆藏信息")
    public Result<List<BookAll>> getBookAll(Integer bookId) {
        LambdaQueryWrapper<BookAll> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BookAll::getBookId, bookId);
        List<BookAll> bookAllList = bookAllService.getBaseMapper().selectList(queryWrapper);
        return Result.success(bookAllList);
    }

    /**
     * 添加图书
     * @param bookInfo 图书信息
     * @return 添加结果
     */
    @PostMapping("/save-book")
    @ApiOperation(value = "添加图书")
    public Result<String> saveBook(BookInfo bookInfo) {
        boolean saveStatus = bookInfoService.save(bookInfo);
        if (saveStatus) {
            return Result.success("添加成功");
        }
        return Result.error(0, "添加失败");
    }

    /**
     * 添加图书馆藏信息
     * @param bookAll 图书馆藏信息
     * @return 添加结果
     */
    @PostMapping("/save-book-all")
    @ApiOperation(value = "添加图书馆藏信息")
    public Result<String> saveBookAll(BookAll bookAll) {
        boolean saveStatus = bookAllService.save(bookAll);
        if (saveStatus) {
            return Result.success("添加成功");
        }
        return Result.error(0, "添加失败");
    }

    /**
     * 修改图书信息
     * @param bookInfo 图书信息
     * @return 修改结果
     */
    @PutMapping("/update-book")
    @ApiOperation(value = "修改图书信息")
    public Result<String> updateBook(BookInfo bookInfo) {
        boolean updateStatus = bookInfoService.updateById(bookInfo);
        if (updateStatus) {
            return Result.success("修改成功");
        }
        return Result.error(0, "修改失败");
    }

    /**
     * 修改图书馆藏信息
     * @param bookAll 图书馆藏信息
     * @return 修改结果
     */
    @PutMapping("/update-book-all")
    @ApiOperation(value = "修改图书馆藏信息")
    public Result<String> updateBookAll(BookAll bookAll) {
        boolean updateStatus = bookAllService.updateById(bookAll);
        if (updateStatus) {
            return Result.success("修改成功");
        }
        return Result.error(0, "修改失败");
    }
}
