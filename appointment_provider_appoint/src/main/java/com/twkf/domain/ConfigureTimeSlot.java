package com.twkf.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_configure_time_slot")
@ApiModel(description= "时间配置")
public class ConfigureTimeSlot {
  @TableId(type = IdType.AUTO)
  @ApiModelProperty(value="id",name="id",dataType = "String")
  private String id;
  @ApiModelProperty(value="1:上午9点至10点半 2:上午10点半至12点 3:下午1点至2点半 4 :下午2点半至4点 5:夜间5点到7点",name="configureTimeType",dataType = "String")
  private String configureTimeType;
  @ApiModelProperty(value="1:4s店 2：市民中心 3:管理部门",name="companyType",dataType = "String")
  private String companyType;
  @ApiModelProperty(value="时间段",name="timeSlot",dataType = "String")
  private String timeSlot;
  @ApiModelProperty(value="开始时间",name="startTime",dataType = "String")
  private String startTime;
  @ApiModelProperty(value="结束时间",name="endTime",dataType = "String")
  private String endTime;
}
