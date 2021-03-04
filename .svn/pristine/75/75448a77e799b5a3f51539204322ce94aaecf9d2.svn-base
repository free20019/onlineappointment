package com.twkf.controller;

import com.twkf.domain.Company;
import com.twkf.domain.ManageConfigure;
import com.twkf.domain.ReturnAppointResult;
import com.twkf.exception.GlobalException;
import com.twkf.service.AppointService;
import com.twkf.util.ValidatorUtil;
import com.twkf.vo.*;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author: xianlehuang
 * @Description: 在线预约
 * @date: 2021/1/27 - 15:12
 */
@Controller
@RequestMapping("/appoint")
@Slf4j
@Api(tags = "在线预约")
public class AppointController {

    @Autowired
    AppointService appointService;

    @PostMapping("/getAllCompany")
    @ResponseBody
    @ApiOperation(value = "获取所有公司")
    public Result<List<Company>> getAllCompany() {
        return appointService.getAllCompany();
    }

    @PostMapping("/getCompanyDetails")
    @ResponseBody
    @ApiOperation(value = "获取单个公司发布信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId" ,value = "公司id", required = true,dataType = "String"),
    })
    public Result<List<ManageConfigure>> getCompanyDetail(@RequestParam("companyId")  String companyId) {
        if(StringUtils.isEmpty(companyId)){
            throw new GlobalException("请填写公司id！");
        }
        return appointService.getCompanyDetails(companyId);
    }

    @PostMapping("/getCompanyDetail")
    @ResponseBody
    @ApiOperation(value = "获取单个公司某一天信息")
    public Result<List<ManageConfigure>> getCompanyDetail(@RequestBody @Valid  CompanyVo companyVo) {
        return appointService.getCompanyDetail(companyVo);
    }

    @PostMapping("/getCompanyDetailById")
    @ResponseBody
    @ApiOperation(value = "获取单个公司某一天某一场次信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" ,value = "id",required = true,dataType = "String"),
    })
    public Result<ManageConfigure> getCompanyDetailById(@RequestParam("id")  String id) {
        if(StringUtils.isEmpty(id)){
            throw new GlobalException("请填写id！");
        }
        return appointService.getCompanyDetailById(id);
    }

    @PostMapping("/userAppoint")
    @ResponseBody
    @ApiOperation(value = "用户预约")
    public Result userAppoint(@RequestBody @Valid AppointVo appointVo) {
        return appointService.userAppoint(appointVo.getPhone(), appointVo);
    }

    @PostMapping("/getUserAppointHistory")
    @ResponseBody
    @ApiOperation(value = "用户预约记录查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone" ,value = "手机号码",required = true,dataType = "String"),
//            @ApiImplicitParam(name = "code" ,value = "验证码",required = false,dataType = "String"),
    })
    public Result<List<ReturnAppointResult>> getUserAppointHistory(HttpServletRequest request, HttpServletResponse response, @RequestParam("phone")  String phone) {
        if(!ValidatorUtil.isPhone(phone)){
            throw new GlobalException("手机号码格式错误");
        }
        return appointService.getUserAppointHistory(phone);
    }

    @PostMapping("/cancelUserAppoint")
    @ResponseBody
    @ApiOperation(value = "取消预约")
    public Result cancelUserAppoint(@RequestBody @Valid CancelAppointVo cancelAppointVo) {
        return appointService.cancelUserAppoint(cancelAppointVo.getPhone(), cancelAppointVo);
    }
}
