package com.twkf.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author: xianlehuang
 * @Description: 分布式锁切面
 * @date: 2021/2/19 - 15:43
 */
@Aspect
@Component
@Order(1) //该order必须设置，很关键
@Slf4j
public class RedissonLockAspect {
    @Autowired
    private RedissonClient redissonClient;

    @Around("@annotation(redissonLock)")
    public Object around(ProceedingJoinPoint joinPoint, RedissonLock redissonLock) throws Throwable {
        Object obj = null;

        //方法内的所有参数
        Object[] params = joinPoint.getArgs();

        int lockIndex = redissonLock.lockIndex();
        boolean isCommon = redissonLock.isCommon();
        String commonValue = redissonLock.commonValue();
        //多久会自动释放，默认10秒
        int leaseTime = redissonLock.leaseTime();
        //取得方法名或者自定义名称
        String key = "";
        if(isCommon){
            key = commonValue;
        }else{
            key = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        }
        //-1代表锁整个方法，而非具体锁哪条数据
        if (lockIndex != -1) {
            key += params[lockIndex];
        }
        int waitTime = 5;

        RLock rLock = redissonClient.getLock(key);
        if (rLock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS)) {
            try {
//                log.info(key+"取到锁");
                obj = joinPoint.proceed();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(rLock!=null&&rLock.isHeldByCurrentThread()){
                    rLock.unlock();
//                   log.info(key+"释放锁");
                }
            }
        } else {
            log.info(key+"没有获得锁");
            throw new RuntimeException(key+"没有获得锁");
        }

        return obj;
    }
}

