package com.twkf.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/1/27 - 19:35
 */
public class ValidatorUtil {

    public static final Pattern phone_pattern = Pattern.compile("^1[345789]\\d{9}$");

    public static boolean isPhone(String phone){
        if(StringUtils.isEmpty(phone)){
            return false;
        }
        Matcher matcher = phone_pattern.matcher(phone);
        return matcher.matches();
    }

}
