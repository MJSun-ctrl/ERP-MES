package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入库记录对象 stock_in
 * 
 * @author Mingjian Sun
 * @date 2026-08-19
 */
public class StockIn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long stockId;

    /**  */
    @Excel(name = "")
    private Long productId;

    /**  */
    @Excel(name = "")
    private BigDecimal quantity;

    /** 来源MES任务 */
    @Excel(name = "来源MES任务")
    private Long sourceTaskId;

    public void setStockId(Long stockId) 
    {
        this.stockId = stockId;
    }

    public Long getStockId() 
    {
        return stockId;
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

    public void setSourceTaskId(Long sourceTaskId) 
    {
        this.sourceTaskId = sourceTaskId;
    }

    public Long getSourceTaskId() 
    {
        return sourceTaskId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stockId", getStockId())
            .append("productId", getProductId())
            .append("quantity", getQuantity())
            .append("sourceTaskId", getSourceTaskId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
