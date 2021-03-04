package com.twkf.domain;


import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_appoint_error")
@ApiModel(description= "预约失败记录")
public class AppointError {

  @TableId(type = IdType.AUTO)
  @ApiModelProperty(value="id",name="id",dataType = "String")
  private String id;
  @ApiModelProperty(value="配置id",name="configureId",dataType = "String")
  private String configureId;
  @ApiModelProperty(value="公司id",name="companyId",dataType = "String")
  private String companyId;
  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty(value="预约时间",name="appointTime",dataType = "Date")
  private Date appointTime;
  @ApiModelProperty(value="用户名",name="username",dataType = "String")
  private String username;
  @ApiModelProperty(value="手机号码",name="phone",dataType = "String")
  private String phone;
  @ApiModelProperty(value="验证码",name="code",dataType = "String")
  private String code;
  @ApiModelProperty(value="用户id",name="userId",dataType = "String")
  private String userId;
  @ApiModelProperty(value="类型（1：已预约，2：已取消）",name="appointType",dataType = "String")
  private String appointType;
  @ApiModelProperty(value="办事时间",name="handleTime",dataType = "String")
  private Date handleTime;
  @ApiModelProperty(value="UUID",name="appointId",dataType = "String")
  private String appointId;

}
