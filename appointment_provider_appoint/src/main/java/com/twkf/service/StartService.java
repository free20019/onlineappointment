package com.twkf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twkf.dao.ManageConfigureDao;
import com.twkf.domain.Appoint;
import com.twkf.mapper.AppointMapper;
import com.twkf.util.SystemCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/2/19 - 15:01
 */
@Component
@Order(value = 1)
@Slf4j
public class StartService implements ApplicationRunner {
    @Autowired
    ScheduledService scheduledService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("=========== 程序开机启动：开始 =============");
        //查询用户预约信息
        scheduledService.getDay();
        log.info("=========== 程序开机启动：结束 =============");
    }
}
