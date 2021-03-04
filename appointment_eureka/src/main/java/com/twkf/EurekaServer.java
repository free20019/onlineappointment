package com.twkf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: xianlehuang
 * @Description: Eureka
 * @date: 2021/1/27 - 9:50
 */
@EnableEurekaServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class EurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }

}
