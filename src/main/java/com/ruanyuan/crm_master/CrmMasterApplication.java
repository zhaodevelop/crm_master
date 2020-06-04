package com.ruanyuan.crm_master;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(basePackages="com.ruanyuan.crm_master.dao")
public class CrmMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmMasterApplication.class, args);
    }

}
