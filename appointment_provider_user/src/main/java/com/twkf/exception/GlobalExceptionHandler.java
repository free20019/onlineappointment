package com.twkf.exception;

import com.twkf.vo.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public Result<Object> exceptionHandler(HttpServletRequest request,
										   Exception e) {
		if (e instanceof GlobalException) {
			GlobalException be = (GlobalException) e;
			return Result.error( be.getMessage());
		}else if (e instanceof BindException) {
			BindException be = (BindException) e;
			return Result.error(be.getAllErrors().get(0).getDefaultMessage());
		} else if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException be = (MethodArgumentNotValidException) e;
			return Result.error(be.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		} else {
			e.printStackTrace();
			return Result.error(400,"异常错误", e);
		}
	}
}
