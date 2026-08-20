package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料清单对象 bom
 * 
 * @author Mingjian Sun
 * @date 2026-08-17
 */
public class Bom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料清单ID */
    private Long bomId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 物料清单编号 */
    @Excel(name = "物料清单编号")
    private String bomCode;

    /** 版本号 */
    @Excel(name = "版本号")
    private String version;

    /** 状态（0启用 1停用） */
    @Excel(name = "状态", readConverterExp = "0=启用,1=停用")
    private String status;

    /** 生效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "生效日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveDate;

    public void setBomId(Long bomId) 
    {
        this.bomId = bomId;
    }

    public Long getBomId() 
    {
        return bomId;
    }

    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }

    public void setBomCode(String bomCode) 
    {
        this.bomCode = bomCode;
    }

    public String getBomCode() 
    {
        return bomCode;
    }

    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setEffectiveDate(Date effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() 
    {
        return effectiveDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bomId", getBomId())
            .append("productId", getProductId())
            .append("bomCode", getBomCode())
            .append("version", getVersion())
            .append("status", getStatus())
            .append("effectiveDate", getEffectiveDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

    private String productName;


public String getProductName()
{
    return productName;
}


public void setProductName(String productName)
{
    this.productName=productName;
}
}
