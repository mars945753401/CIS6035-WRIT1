package com.ruoyi.resource.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * GrsEquip class
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public class GrsEquip extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** Equip ID */
    private Long equipId;

    /** Equip name */
    @Excel(name = "Equip name")
    private String equipName;

    /** Equip type */
    @Excel(name = "Equip type")
    private String equipType;

    /** Equip supplier */
    @Excel(name = "Equip supplier")
    private String supplier;

    /** Equip product date */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Equip product date", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productDate;

    /** Equip description */
    @Excel(name = "Equip description")
    private String equipDesc;

    public void setEquipId(Long equipId) 
    {
        this.equipId = equipId;
    }

    public Long getEquipId() 
    {
        return equipId;
    }
    public void setEquipName(String equipName) 
    {
        this.equipName = equipName;
    }

    public String getEquipName() 
    {
        return equipName;
    }
    public void setEquipType(String equipType) 
    {
        this.equipType = equipType;
    }

    public String getEquipType() 
    {
        return equipType;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setProductDate(Date productDate) 
    {
        this.productDate = productDate;
    }

    public Date getProductDate() 
    {
        return productDate;
    }
    public void setEquipDesc(String equipDesc) 
    {
        this.equipDesc = equipDesc;
    }

    public String getEquipDesc() 
    {
        return equipDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("equipId", getEquipId())
            .append("equipName", getEquipName())
            .append("equipType", getEquipType())
            .append("supplier", getSupplier())
            .append("productDate", getProductDate())
            .append("equipDesc", getEquipDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
