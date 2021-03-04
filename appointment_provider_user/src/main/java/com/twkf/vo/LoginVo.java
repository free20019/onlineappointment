package com.twkf.vo;

import com.twkf.validator.IsPhone;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class LoginVo {
	@NotNull(message = "手机号码不为空")
//	@IsPhone
	@Length(min = 1, message = "请填写手机号码" )
	@Pattern(regexp = "^1[345789]\\d{9}$", message = "手机号格式不正确")
	private String phone;

	@NotNull(message = "密码不为空")
	@Length(min = 1, message = "请填写密码" )
	private String password;
}
