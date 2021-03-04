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
@ApiModel(description= "用户取消预约条件")
public class CancelAppointVo {
    @NotNull(message = "手机号码不为空")
    @Length(min = 1, message = "请填写手机号码" )
    @Pattern(regexp = "^1[345789]\\d{9}$", message = "手机号格式不正确")
    @ApiModelProperty(value="手机号码",name="phone",dataType = "String")
    private String phone;

    @NotNull(message = "验证码不为空")
    @Length(min = 1, message = "请填写验证码" )
    @ApiModelProperty(value="验证码",name="code",dataType = "String")
    private String code;

    @NotNull(message = "预约uuid不为空")
    @Length(min = 1, message = "请填写预约uuid" )
    @ApiModelProperty(value="预约uuid",name="appointId",dataType = "String")
    private String appointId;
}
