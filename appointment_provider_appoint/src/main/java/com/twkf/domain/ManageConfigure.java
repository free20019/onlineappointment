package com.twkf.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_manage_configure")
@ApiModel(description= "公司发布预约信息")
public class ManageConfigure {

  @TableId(type = IdType.AUTO)
  @ApiModelProperty(value="预约信息id",name="id",dataType = "String")
  private String id;
  @ApiModelProperty(value="可预约的时间",name="dbtime",dataType = "Date")
  private Date dbtime;
  @ApiModelProperty(value="预约总数量",name="orderNumber",dataType = "Integer")
  private Integer orderNumber;
  @ApiModelProperty(value="可预约数量",name="surplus_number",dataType = "Integer")
  private Integer surplusNumber;
  @ApiModelProperty(value="1:上午9点至10点半 2:上午10点半至12点 3:下午1点至2点半 4 :下午2点半至4点 5:夜间5点到7点",name="configureTimeType",dataType = "String")
  private String configureTimeType;
  @ApiModelProperty(value="公司id",name="companyId",dataType = "String")
  private String companyId;
  @ApiModelProperty(value="发布状态 0：已发布 1 ：未发布",name="fbtype",dataType = "String")
  private String fbtype;

}
