package com.ruoyi.reservation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * GrsEquipReservation class
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public class GrsEquipReservation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** Equip reservation ID */
    private Long equipReservationId;

    /** Equip ID */
    @Excel(name = "Equip ID")
    private Long equipId;

    /** User ID */
    @Excel(name = "User ID")
    private Long userId;

    /** Equip reservation purpose */
    @Excel(name = "Equip reservation purpose")
    private String erPurpose;

    /** Equip reservation start time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Equip reservation start time", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** Equip reservation end time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Equip reservation end time", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** Equip reservation status */
    @Excel(name = "Equip reservation status")
    private String erStatus;

    public void setEquipReservationId(Long equipReservationId) 
    {
        this.equipReservationId = equipReservationId;
    }

    public Long getEquipReservationId() 
    {
        return equipReservationId;
    }
    public void setEquipId(Long equipId) 
    {
        this.equipId = equipId;
    }

    public Long getEquipId() 
    {
        return equipId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setErPurpose(String erPurpose) 
    {
        this.erPurpose = erPurpose;
    }

    public String getErPurpose() 
    {
        return erPurpose;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setErStatus(String erStatus) 
    {
        this.erStatus = erStatus;
    }

    public String getErStatus() 
    {
        return erStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("equipReservationId", getEquipReservationId())
            .append("equipId", getEquipId())
            .append("userId", getUserId())
            .append("erPurpose", getErPurpose())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("erStatus", getErStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
