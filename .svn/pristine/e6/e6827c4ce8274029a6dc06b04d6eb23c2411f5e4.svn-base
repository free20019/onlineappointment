package com.twkf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/1/29 - 10:25
 */
@Data
@ApiModel(description= "用户预约条件")
public class AppointVo {
    @NotNull(message = "手机号码不为空")
    @Length(min = 1, message = "请填写手机号码" )
    @Pattern(regexp = "^1[345789]\\d{9}$", message = "手机号格式不正确")
    @ApiModelProperty(value="手机号码",name="phone",dataType = "String")
    private String phone;

    @NotNull(message = "用户名不为空")
    @Length(min = 1, message = "请填写用户名" )
    @ApiModelProperty(value="用户名",name="username",dataType = "String")
    private String username;

    @NotNull(message = "验证码不为空")
    @Length(min = 1, message = "请填写验证码" )
    @ApiModelProperty(value="验证码",name="code",dataType = "String")
    private String code;

    @NotNull(message = "预约信息id不为空")
    @Length(min = 1, message = "请填写预约信息id" )
    @ApiModelProperty(value="预约信息id",name="id",dataType = "String")
    private String id;

    @NotNull(message = "预约时间类型不为空")
    @Length(min = 1, message = "请填写预约时间类型" )
    @ApiModelProperty(value="1:上午9点至10点半 2:上午10点半至12点 3:下午1点至2点半 4 :下午2点半至4点 5:夜间5点到7点",name="configureTimeType",dataType = "String")
    private String configureTimeType;


    @NotNull(message = "公司id不为空")
    @Length(min = 1, message = "请填写公司id" )
    @ApiModelProperty(value="公司id",name="companyId",dataType = "String")
    private String companyId;

    @NotNull(message = "预约时间不为空")
    @Length(min = 10, message = "请填写预约时间" )
    @Pattern(regexp = "^\\d{4}(\\-)\\d{1,2}(\\-)\\d{1,2}$", message = "时间格式不正确")
    @ApiModelProperty(value="预约时间（例：2021-01-28）",name="time",dataType = "String")
    private String time;

}
