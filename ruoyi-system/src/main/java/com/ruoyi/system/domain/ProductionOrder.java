package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产工单对象 production_order
 * 
 * @author Mingjian Sun
 * @date 2026-08-18
 */
public class ProductionOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工单ID */
    private Long orderId;

    /** 工单编号 */
    @Excel(name = "工单编号")
    private String orderCode;

    /** 来源生产计划ID */
    @Excel(name = "来源生产计划ID")
    private Long planId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;


    /**
 * 产品名称（页面展示）
 */
private String productName;


/**
 * 来源计划编号（页面展示）
 */
private String planCode;

    /** 生产数量 */
    @Excel(name = "生产数量")
    private BigDecimal quantity;

    /** 状态 0待下达 1已下达MES 2生产中 3完成 */
    @Excel(name = "状态 0待下达 1已下达MES 2生产中 3完成")
    private String status;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }

    public void setOrderCode(String orderCode) 
    {
        this.orderCode = orderCode;
    }

    public String getOrderCode() 
    {
        return orderCode;
    }

    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setQuantity(BigDecimal quantity) 
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() 
    {
        return quantity;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public String getProductName()
{
    return productName;
}

public void setProductName(String productName)
{
    this.productName = productName;
}


public String getPlanCode()
{
    return planCode;
}

public void setPlanCode(String planCode)
{
    this.planCode = planCode;
}

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderCode", getOrderCode())
            .append("planId", getPlanId())
            .append("productId", getProductId())
            .append("productName", getProductName())
            .append("planCode", getPlanCode())
            .append("quantity", getQuantity())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
