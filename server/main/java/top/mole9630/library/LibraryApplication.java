package top.mole9630.library;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Slf4j // lombok提供的日志注解
@ServletComponentScan // 扫描@WebFilter注解
@EnableTransactionManagement // 开启事务
@EnableCaching // 开启缓存注解功能
@EnableScheduling //开启定时任务
public class LibraryApplication  {
	public static void main(String[] args)  {
		SpringApplication.run(LibraryApplication.class, args);
		log.info("项目启动成功");
//		System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
	}
}
