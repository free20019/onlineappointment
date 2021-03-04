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
@TableName(value = "tb_phone_code")
@ApiModel(description= "手机验证码")
public class PhoneCode {

  @TableId(type = IdType.AUTO)
  @ApiModelProperty(value="id",name="id",dataType = "String")
  private long id;
  @ApiModelProperty(value="手机号码",name="phone",dataType = "String")
  private String phone;
  @ApiModelProperty(value="验证码",name="code",dataType = "String")
  private String code;
  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty(value="创建时间",name="createTime",dataType = "Date")
  private Date createTime;
  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty(value="过期时间",name="overdueTime",dataType = "Date")
  private Date overdueTime;
  @ApiModelProperty(value="类型 0:预约  1：取消预约", name="type", dataType = "String")
  private String type;
}
