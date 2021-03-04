package com.twkf.util;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.twkf.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/2/3 - 10:17
 */
@Slf4j
@Component
public class MessageUtil {

    private static String active;

    @Value("${spring.profiles.active}")
    private String activeTemp;

    @PostConstruct
    public void init(){
        active=activeTemp;
    }

    public static Result sendMessage(String phone, String message){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("compName","tongwoo");
        requestMap.put("token","23vds8g3gf309");
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        map = new HashMap<>();
        map.put("mobile",phone);
        map.put("message",message);
        map.put("sendType",0);
//      map.put("sendTime","");
        list.add(map);
        requestMap.put("body",list);
        log.info("短信接口："+phone+"手机短信请求："+requestMap);
        try {
            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            HttpHeaders headers = new HttpHeaders();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);
            headers.add("Content-Type", "text/plain");
            Gson gson = new Gson();
            HttpEntity<String> formEntity = new HttpEntity<String>(gson.toJson(requestMap), headers);
            if(!"test".equals(active)){
                Map body = restTemplate.postForObject(SystemCode.MESSAGE_URL, formEntity, Map.class);
                log.info("短信接口："+phone+"手机短信响应："+body);
                if (body!=null){
                    if("200".equals(String.valueOf(body.get("code")))){
                        return Result.success();
                    }else{
                        return Result.error(String.valueOf(body.get("info")));
                    }
                }
            }else{
                return Result.error("测试环境！");
            }
        }catch (Exception e){
           e.printStackTrace();
           log.info("短信接口："+phone+"手机短信请求错误："+e);
           log.error("短信接口："+phone+"手机短信请求错误："+e);
        }

        return Result.error("短信请求失败！");
    }

}
