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
 * @date: 2021/1/28 - 19:03
 */
@Data
@ApiModel(description= "预约信息查询条件")
public class CompanyVo {


    @NotNull(message = "公司id不为空")
    @Length(min = 1, message = "请填写公司id" )
    @ApiModelProperty(value="公司id",name="companyId",dataType = "String")
    private String companyId;

    @NotNull(message = "时间不为空")
    @Length(min = 10, message = "请填写时间" )
    @ApiModelProperty(value="预约的时间（例：2021-01-28）",name="time",dataType = "String")
    @Pattern(regexp = "^\\d{4}(\\-)\\d{1,2}(\\-)\\d{1,2}$", message = "时间格式不正确")
    private String time;
}
