package com.twkf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xianlehuang
 * @Description: UserServer
 * @date: 2021/1/27 - 9:50
 */
@MapperScan("com.twkf.mapper")
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class ProviderUserServer {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserServer.class, args);
    }

}
