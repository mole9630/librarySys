package top.mole9630.library.task;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import top.mole9630.library.entity.LendList;
import top.mole9630.library.service.LendListService;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ReminderToReturnTask {
    @Autowired
    private LendListService lendListService;

    /**
     * 每天凌晨0点执行一次检查1天后到期的借阅单
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void overdueAfterOneDay() {
        LocalDateTime dateTime = LocalDateTime.now().plusDays(2);
//        System.out.println(dateTime);
        LambdaQueryWrapper<LendList> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(LendList::getBackDate,dateTime);
        List<LendList> lendLists = lendListService.list(queryWrapper);
        for (LendList lendList : lendLists) {
            // 发送借阅到期提醒
        }
    }
}
