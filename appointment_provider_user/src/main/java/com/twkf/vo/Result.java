package com.twkf.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/1/27 - 15:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description= "返回结果信息")
public class Result<T> {
    @ApiModelProperty(value="状态码",name="state",dataType = "Integer")
    private int code;
    @ApiModelProperty(value="状态信息",name="msg",dataType = "String")
    private String message;
    @ApiModelProperty(value="返回数据",name="data",dataType = "Object")
    private T obj;

    public static <T> Result<T> success(){
        return new Result<T>(200, "成功", null);
    }

    public static <T> Result<T> success( T obj){
        return new Result<T>(200, "成功", obj);
    }

    public static <T> Result<T> success(String message, T obj){
        return new Result<T>(200, message, obj);
    }

    public static <T> Result<T> error(){
        return new Result<T>(400, "失败", null);
    }

    public static <T> Result<T> error(String message){
        return new Result<T>(400, message, null);
    }

    public static <T> Result<T> error(Integer code, String message){
        return new Result<T>(code, message, null);
    }

    public static <T> Result<T> error(Integer code, String message, T obj){
        return new Result<T>(code, message, obj);
    }
}
