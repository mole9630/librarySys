package top.mole9630.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mole9630.library.common.Result;
import top.mole9630.library.entity.BookAll;
import top.mole9630.library.entity.LendList;
import top.mole9630.library.entity.User;
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.LendListService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lend")
@Api(tags = "借阅相关接口")
@Slf4j
public class LendListController {
    @Autowired
    private LendListService lendListService;
    @Autowired
    private BookAllService bookAllService;

    /**
     * 获取借阅列表
     * @param request 请求
     * @return 借阅列表
     */
    @GetMapping("/get-lend")
    @ApiOperation(value = "获取图书借阅记录")
    public Result<List<LendList>> getLendList(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        LambdaQueryWrapper<LendList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LendList::getUserId, user.getId());
        List<LendList> lendLists = lendListService.list(queryWrapper);
        return Result.success(lendLists);
    }

    /**
     * 借阅图书
     * @param request 请求
     * @param barcode 图书条形码
     * @return 借阅结果
     */
    @PutMapping("/lend-book")
    @ApiOperation(value = "借阅图书")
    public Result<String> lendBook(HttpServletRequest request, Integer barcode) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return Result.error(0, "请先登录");
        }
        if (barcode == null) {
            return Result.error(0, "参数错误, 请稍后重试");
        }

        // 判断图书是否已经被借出
        BookAll bookAll = bookAllService.getById(barcode);
        if (bookAll.getLendStatus() == 0) {
            return Result.error(0, "该图书已被借出");
        }
        lendListService.lendBook(user.getId(), barcode);
        return Result.success("借阅成功");
    }

    /**
     * 归还图书
     * @param request 请求
     * @param barcode 图书条形码
     * @return 归还结果
     */
    @PutMapping("/back-book")
    @ApiOperation(value = "归还图书")
    public Result<String> backBook(HttpServletRequest request, Integer barcode) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return Result.error(0, "请先登录");
        }
        if (barcode == null) {
            return Result.error(0, "参数错误, 请稍后重试");
        }

        // 判断图书是否为该用户借出
        LambdaQueryWrapper<LendList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LendList::getUserId, user.getId());
        queryWrapper.eq(LendList::getBookId, barcode);
        queryWrapper.eq(LendList::getBackStatus, 0);
        LendList lendList = lendListService.getOne(queryWrapper);
        if (lendList == null) {
            return Result.error(0, "该图书不是您借出的");
        }

        // 执行归还方法
        lendListService.backBook(user.getId(), barcode, lendList.getCode());
        return Result.success("归还成功");
    }
}
