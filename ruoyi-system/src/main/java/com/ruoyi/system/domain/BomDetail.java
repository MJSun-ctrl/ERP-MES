package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料清单明细对象 bom_detail
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
public class BomDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细ID */
    private Long detailId;

    /** 物料清单ID */
    @Excel(name = "物料清单ID")
    private Long bomId;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialId;

/** 物料名称 */
private String materialName;

public String getMaterialName()
{
    return materialName;
}

public void setMaterialName(String materialName)
{
    this.materialName = materialName;
}

    /** 用量 */
    @Excel(name = "用量")
    private BigDecimal quantity;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }

    public void setBomId(Long bomId) 
    {
        this.bomId = bomId;
    }

    public Long getBomId() 
    {
        return bomId;
    }

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }

    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailId", getDetailId())
            .append("materialName", getMaterialName())
            .append("bomId", getBomId())
            .append("materialId", getMaterialId())
            .append("quantity", getQuantity())
            .append("unit", getUnit())
            .append("remark", getRemark())
            .toString();
    }
}
