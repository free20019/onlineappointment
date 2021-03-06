package com.twkf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2021/2/1 - 11:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description= "返回预约记录结果")
public class ReturnAppointResult{
    @ApiModelProperty(value="是否可以预约或者取消预约",name="isCancel",dataType = "Boolean", hidden = true)
    @JsonIgnore
    private Boolean isCan;
    @ApiModelProperty(value="是否是今日预约的",name="isToday",dataType = "Boolean", hidden = true)
    @JsonIgnore
    private Boolean isToday;
    @ApiModelProperty(value="取消预约时间限制（分钟）",name="CancelOvertime",dataType = "Integer")
    private Integer cancelOvertime;
    @ApiModelProperty(value="时间配置",name="timeSlot",dataType = "ConfigureTimeSlot")
    private ConfigureTimeSlot timeSlot;
    @ApiModelProperty(value="预约记录",name="appoint",dataType = "appoint")
    private Appoint appoint;
    @ApiModelProperty(value="公司",name="company",dataType = "Company")
    private Company company;
    @ApiModelProperty(value="发布信息",name="manageConfigure",dataType = "ManageConfigure")
    private ManageConfigure manageConfigure;
}
