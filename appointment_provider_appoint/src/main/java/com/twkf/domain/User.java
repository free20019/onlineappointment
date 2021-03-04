package com.twkf.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xianlehuang
 * @Description: 用户
 * @date: 2021/1/27 - 15:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "Tb_appoint_user")
@ApiModel(description= "用户")
public class User {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="id",name="id",dataType = "String")
    private long id;
    @ApiModelProperty(value="手机号码",name="phone",dataType = "String")
    private long phone;
    @ApiModelProperty(value="用户名",name="username",dataType = "String")
    private String username;
    @ApiModelProperty(value="密码",name="password",dataType = "String")
    private String password;

    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value="注册时间",name="registerDate",dataType = "Date")
    private Date registerDate;

    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value="最后登录时间",name="lastLoginTime",dataType = "Date")
    private Date lastLoginTime;

    @ApiModelProperty(value="登录次数",name="loginCount",dataType = "String")
    private long loginCount;

}
