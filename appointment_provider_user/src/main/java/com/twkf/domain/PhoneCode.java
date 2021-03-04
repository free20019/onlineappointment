package com.twkf.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_phone_code")
public class PhoneCode {

  @TableId(type = IdType.AUTO)
  private long id;
  private String phone;
  private String code;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT)
  private Date overdueTime;
}
