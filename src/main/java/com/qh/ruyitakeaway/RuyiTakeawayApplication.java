package com.qh.ruyitakeaway;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 如意外卖应用程序
 *
 * @author qh
 * @date 2022/10/09 13:16:34
 */
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.qh.ruyitakeaway.mapper")
@EnableTransactionManagement//开启事务
@EnableAspectJAutoProxy // 开启切面
@EnableCaching//开启缓存
public class RuyiTakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuyiTakeawayApplication.class, args);
        log.info("项目启动成功！！！");
    }

}
