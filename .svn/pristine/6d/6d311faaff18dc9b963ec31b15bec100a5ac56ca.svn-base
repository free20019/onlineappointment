package com.twkf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author: xianlehuang
 * @Description: Eureka
 * @date: 2021/1/27 - 9:50
 */
@MapperScan({"com.twkf.mapper","com.twkf.dao"})
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
@EnableScheduling//开启基于注解的定时任务
@EnableAsync//异步
public class ProviderAppointServer {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAppointServer.class, args);
    }

}
