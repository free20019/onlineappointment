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
@TableName(value = "tb_message_appoint")
@ApiModel(description= "预约成功发送短信")
public class MessageAppoint {
  @TableId(type = IdType.AUTO)
  @ApiModelProperty(value="id",name="id",dataType = "String")
  private long id;

  @ApiModelProperty(value="手机号码",name="phone",dataType = "String")
  private String phone;

  @ApiModelProperty(value="配置id",name="configureId",dataType = "String")
  private String configureId;

  @ApiModelProperty(value="公司id",name="companyId",dataType = "String")
  private String companyId;

  @ApiModelProperty(value="短信",name="message",dataType = "String")
  private String message;

  @ApiModelProperty(value="业务操作是否成功  0：成功 1：失败",name="appointSuccess",dataType = "String")
  private String appointSuccess;

  @ApiModelProperty(value="短信是否发送成功 0：成功 1：失败",name="isSuccess",dataType = "String")
  private String isSuccess;

  @ApiModelProperty(value="短信发送失败原因",name="errorReason",dataType = "String")
  private String errorReason;

  @TableField(fill = FieldFill.INSERT)
  @ApiModelProperty(value="创建时间",name="createTime",dataType = "Date")
  private Date createTime;

  @ApiModelProperty(value="类型 0:预约  1：取消预约", name="type", dataType = "String")
  private String type;

}
