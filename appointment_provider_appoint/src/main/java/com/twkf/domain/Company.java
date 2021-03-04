package com.twkf.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_company")
@ApiModel(description= "公司信息")
public class Company {
  @ApiModelProperty(value="公司名",name="companyName",dataType = "String")
  private String companyName;
  @ApiModelProperty(value="公司地址",name="companyAddress",dataType = "String")
  private String companyAddress;
  @ApiModelProperty(value="公司区域",name="companyArea",dataType = "String")
  private String companyArea;
  @ApiModelProperty(value="公司电话",name="companyPhone",dataType = "String")
  private String companyPhone;
  @ApiModelProperty(value="经度",name="lon",dataType = "String")
  private String lon;
  @ApiModelProperty(value="纬度",name="lat",dataType = "String")
  private String lat;
  @ApiModelProperty(value="公司id",name="companyId",dataType = "String")
  private String companyId;
  @ApiModelProperty(value="公司类型(1:4s店 2：市民中心 3:管理部门)",name="companyType",dataType = "String")
  private String companyType;

  @ApiModelProperty(value="公司共可预约{日期,数量}",name="map",dataType = "String")
  //每一天可预约的数量
  @TableField(exist = false)
  private Map<String, Integer> map;

  //共可预约数
  @ApiModelProperty(value="公司共可预约数",name="count",dataType = "Integer")
  @TableField(exist = false)
  private Integer count;

  //共预约数
  @ApiModelProperty(value="公司共预约数",name="total",dataType = "Integer")
  @TableField(exist = false)
  private Integer total;

  //可预约的总场次
  @ApiModelProperty(value="可预约的总场次",name="sessions",dataType = "Integer")
  @TableField(exist = false)
  private Integer sessions;

}
