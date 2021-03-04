package com.twkf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author: xianlehuang
 * @Description: 分布式锁注解
 * @date: 2021/2/19 - 15:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedissonLock {
    /**
     * 要锁哪个参数
     */
    int lockIndex() default -1;

    /**
     * 锁多久后自动释放（单位：秒）
     */
    int leaseTime() default 10;

    /**
     * 是否和别的方法共同持有锁
     */
    boolean isCommon() default false;

    /**
     * 共同持有锁名称
     */
    String commonValue() default "";
}
