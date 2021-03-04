package com.twkf.controller;

import com.twkf.exception.GlobalException;
import com.twkf.service.UserService;
import com.twkf.util.ValidatorUtil;
import com.twkf.vo.LoginVo;
import com.twkf.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/1/27 - 15:12
 */
@Controller
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/do_login")
    @ResponseBody
    @ApiOperation(value = "登录", hidden = true)
    public Result login(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        // 登录
        return userService.login(request, response, loginVo);
    }

    @PostMapping("/getPhoneCode")
    @ResponseBody
    @ApiOperation(value = "用户获取验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone" ,value = "手机号码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "type" ,value = "发送类型 0:预约  1：取消预约",required = false,dataType = "Integer", defaultValue = "0"),
    })
    public Result getPhoneCode(HttpServletRequest request, HttpServletResponse response, @RequestParam("phone")  String phone, Integer type) {
        type = type == null? 0 : type;
        if(!ValidatorUtil.isPhone(phone)){
            throw new GlobalException("手机号码格式错误");
        }
        return userService.getPhoneCode(phone, type);
    }

    @PostMapping("/CheckPhoneCode")
    @ResponseBody
    @ApiOperation(value = "用户输入的验证码验证",hidden = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone" ,value = "手机号码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "username" ,value = "用户名",required = false,dataType = "String"),
            @ApiImplicitParam(name = "code" ,value = "验证码",required = true,dataType = "String"),
            @ApiImplicitParam(name = "type" ,value = "发送类型 0:预约  1：取消预约",required = false,dataType = "Integer", defaultValue = "0"),
    })
    public Result CheckPhoneCode(HttpServletRequest request, HttpServletResponse response, @RequestParam("phone")  String phone, @RequestParam("username")  String username, @RequestParam("code")  String code, Integer type) {
        type = type == null? 0 : type;
        if(type==0){
            if(StringUtils.isEmpty(username)){
                throw new GlobalException("用户名不为空");
            }
        }
        if(!ValidatorUtil.isPhone(phone)){
            throw new GlobalException("手机号码格式错误");
        }
        if(StringUtils.isEmpty(code)){
            throw new GlobalException("验证码不为空");
        }
        return userService.CheckPhoneCode(phone, username, code, type);
    }

    @PostMapping("/visit")
    @ResponseBody
    @ApiOperation(value = "访问")
    public Result visit(HttpServletRequest request, HttpServletResponse response) {
        return userService.visit();
    }

}
