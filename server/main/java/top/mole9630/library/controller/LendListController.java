package top.mole9630.library.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mole9630.library.common.Result;
import top.mole9630.library.entity.LendList;
import top.mole9630.library.entity.User;
import top.mole9630.library.service.BookAllService;
import top.mole9630.library.service.LendListService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lend")
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
    public Result<String> lendBook(HttpServletRequest request, Integer barcode) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return Result.error(0, "请先登录");
        }
        if (barcode == null) {
            return Result.error(0, "参数错误, 请稍后重试");
        }
        lendListService.lendBook(user.getId(), barcode);
        return Result.success("借阅成功");
    }
}
