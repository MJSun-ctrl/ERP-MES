package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品管理对象 product
 * 
 * @author Mingjian Sun
 * @date 2026-08-16
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 浜у搧ID */
    private Long productId;

    /** 浜у搧缂栫爜 */
    @Excel(name = "浜у搧缂栫爜")
    private String productCode;

    /** 浜у搧鍚嶇О */
    @Excel(name = "浜у搧鍚嶇О")
    private String productName;

    /** 瑙勬牸鍨嬪彿 */
    @Excel(name = "瑙勬牸鍨嬪彿")
    private String specification;

    /** 鍗曚綅 */
    @Excel(name = "鍗曚綅")
    private String unit;

    /** 浜у搧绫诲瀷 */
    @Excel(name = "浜у搧绫诲瀷")
    private String productType;

    /** 鐘舵?锛?姝ｅ父 1鍋滅敤锛 */
    @Excel(name = "鐘舵?锛?姝ｅ父 1鍋滅敤锛")
    private String status;

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }

    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }

    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }

    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productId", getProductId())
            .append("productCode", getProductCode())
            .append("productName", getProductName())
            .append("specification", getSpecification())
            .append("unit", getUnit())
            .append("productType", getProductType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
