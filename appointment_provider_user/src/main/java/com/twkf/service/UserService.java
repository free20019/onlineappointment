package com.twkf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.twkf.domain.PhoneCode;
import com.twkf.domain.User;
import com.twkf.exception.GlobalException;
import com.twkf.mapper.PhoneCodeMapper;
import com.twkf.mapper.UserMapper;
import com.twkf.util.SystemCode;
import com.twkf.util.UUIDUtil;
import com.twkf.vo.LoginVo;
import com.twkf.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/1/27 - 15:13
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PhoneCodeMapper phoneCodeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    public Result login(HttpServletRequest request, HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException("用户信息为空!!");
        }
        String formPass = loginVo.getPassword();

        // 判断用户否存在
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("phone", loginVo.getPhone()));
        if (user == null) {
            throw new GlobalException("用户不存在");
        }
        // 验证密码
        String PassDB = user.getPassword();
        if (!formPass.equals(PassDB)) {
            throw new GlobalException("密码错误");
        }
        String token = UUIDUtil.Uuid();
//        addCookie(response, token, user);
//        insertLoginHistory(username);
        return Result.success();
    }

    @Transactional
    public Result getPhoneCode(String phone) {
        String code = "";
        //判断是否存在有效的验证码
        String redisCode = (String) redisTemplate.opsForValue().get(SystemCode.CODE_PHONE_PREFIX + phone);
        if(redisCode != null){
            return Result.error("验证码已经发送了！");
        }
        //获取短信验证码


        //把短息验证码入库
        PhoneCode phoneCode = new PhoneCode();
        phoneCode.setPhone(phone);
        phoneCode.setCode(code);
        phoneCode.setOverdueTime(new Date());
        phoneCode.setOverdueTime(new Date(System.currentTimeMillis()+ SystemCode.PHONE_CODE_OVERTIME*60*1000));
        int insert = phoneCodeMapper.insert(phoneCode);
        if(insert>0){
            redisTemplate.opsForValue().set(SystemCode.CODE_PHONE_PREFIX+phone, code, SystemCode.PHONE_CODE_OVERTIME*60, TimeUnit.SECONDS);
            return Result.success(code);
        }else{
            return Result.error();
        }


    }

    public Result CheckPhoneCode(String phone, String username, String code) {
        String redisCode = (String) redisTemplate.opsForValue().get(SystemCode.CODE_PHONE_PREFIX + phone);
        if(redisCode == null){
            return Result.error("验证码已过期,请重新发送！");
        }else if(code.equals(redisCode)){
            return Result.success();
        }else{
            return Result.error("验证码错误！");
        }

    }
}
