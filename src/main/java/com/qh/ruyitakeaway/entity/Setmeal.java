package com.qh.ruyitakeaway.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 套餐
 * </p>
 *
 * @author QH
 * @since 2022-09-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Setmeal对象", description="套餐")
public class Setmeal implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "菜品分类id")
    private Long categoryId;

    @ApiModelProperty(value = "套餐名称")
    private String name;

    @ApiModelProperty(value = "套餐价格")
    private BigDecimal price;

    @ApiModelProperty(value = "状态 0:停用 1:启用")
    private Integer status;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    private Long createUser;

    @ApiModelProperty(value = "修改人")
    private Long updateUser;

    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;


}
