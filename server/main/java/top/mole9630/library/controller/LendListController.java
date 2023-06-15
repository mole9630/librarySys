package top.mole9630.library.controller;

import cn.dev33.satoken.stp.StpUtil;
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
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.LendListService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     * @return 借阅列表
     */
    @GetMapping("/get-lend")
    @ApiOperation(value = "获取图书借阅记录")
    public Result<List<LendList>> getLendList() {
        // 判断是否登录
        if (!StpUtil.isLogin()) {
            return Result.error(0, "登录态失效, 请重新登录");
        }
        // 获取用户ID
        int userId = StpUtil.getLoginIdAsInt();
        LambdaQueryWrapper<LendList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LendList::getUserId, userId);
        List<LendList> lendLists = lendListService.list(queryWrapper);
        return Result.success(lendLists);
    }

    /**
     * 借阅图书
     * @param barcode 图书条形码
     * @return 借阅结果
     */
    @PutMapping("/lend-book")
    @ApiOperation(value = "借阅图书")
    public Result<String> lendBook(Integer barcode) {
        // 判断是否登录
        if (!StpUtil.isLogin()) {
            return Result.error(0, "登录态失效, 请重新登录");
        }
        // 获取用户ID
        int userId = StpUtil.getLoginIdAsInt();

        if (barcode == null) {
            return Result.error(0, "参数错误, 请稍后重试");
        }

        // 判断图书是否已经被借出
        BookAll bookAll = bookAllService.getById(barcode);
        if (bookAll.getLendStatus() == 0) {
            return Result.error(0, "该图书已被借出");
        }
        lendListService.lendBook(userId, barcode);
        return Result.success(null, "借阅成功");
    }

    /**
     * 归还图书
     * @param barcode 图书条形码
     * @return 归还结果
     */
    @PutMapping("/back-book")
    @ApiOperation(value = "归还图书")
    public Result<String> backBook(Integer barcode) {
        // 判断是否登录
        if (!StpUtil.isLogin()) {
            return Result.error(0, "登录态失效, 请重新登录");
        }
        // 获取用户ID
        int userId = StpUtil.getLoginIdAsInt();

        if (barcode == null) {
            return Result.error(0, "参数错误, 请稍后重试");
        }

        // 判断图书是否为该用户借出
        LambdaQueryWrapper<LendList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LendList::getUserId, userId);
        queryWrapper.eq(LendList::getBookId, barcode);
        LendList lendList = lendListService.getOne(queryWrapper);
        if (lendList == null) {
            return Result.error(0, "该图书不是您借出的");
        }

        // 执行归还方法
        lendListService.backBook(userId, barcode, lendList.getCode());
        return Result.success(null, "归还成功");
    }

    @PutMapping("/renewal")
    @ApiOperation(value = "续借图书")
    public Result<String> renewal(Integer barcode) {
        // 判断是否登录
        if (!StpUtil.isLogin()) {
            return Result.error(0, "登录态失效, 请重新登录");
        }
        // 获取用户ID
        int userId = StpUtil.getLoginIdAsInt();

        if (barcode == null) {
            return Result.error(0, "参数错误, 请稍后重试");
        }

        // 判断图书是否为该用户借出
        LambdaQueryWrapper<LendList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(LendList::getUserId, userId);
        queryWrapper.eq(LendList::getBookId, barcode);
        LendList lendList = lendListService.getOne(queryWrapper);
        if (lendList == null) {
            return Result.error(0, "该图书不是您借出的");
        }
        if (lendList.getRenewal() == 1) {
            return Result.error(0, "该图书达到最大续借次数上限");
        }

        lendList.setRenewal(lendList.getRenewal() + 1);
        // 时间加一个月
        String backDate = lendList.getBackDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(backDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date); //设置起时间
        cal.add(Calendar.MONTH, 1); //增加一个月

        lendList.setBackDate(sdf.format(cal.getTime()));
        lendListService.updateById(lendList);

        return Result.success(null, "续借成功");
    }
}
