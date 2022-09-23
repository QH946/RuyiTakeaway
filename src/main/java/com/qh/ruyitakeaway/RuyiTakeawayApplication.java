package com.qh.ruyitakeaway;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@MapperScan(basePackages = "com.qh.ruyitakeaway.mapper")
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching
public class RuyiTakeawayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuyiTakeawayApplication.class, args);
        log.info("项目启动成功！！！");
    }

}
