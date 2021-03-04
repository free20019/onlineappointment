package com.twkf.domain;

import com.baomidou.mybatisplus.annotation.*;
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
public class User {

    @TableId(type = IdType.AUTO)
    private long id;
    private long phone;
    private String username;
    private String password;

    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date registerDate;

    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastLoginTime;

    private long loginCount;

}
