package com.yy.generator.criteria;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: yy
 * @date: 2020/6/4 16:00
 */
@Data
public class ColumnInfo {

    @ApiModelProperty(value = "字段类型")
    private String propertyType;

    @ApiModelProperty(value = "字段名称")
    private String propertyName;

    @ApiModelProperty(value = "数据库字段名称")
    private String columnName;

    @ApiModelProperty(value = "查询 1:模糊 2：精确")
    private String queryType;
}
