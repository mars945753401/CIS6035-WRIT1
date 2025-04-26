package com.ruoyi.reservation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * GrsCourseReservation class
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public class GrsCourseReservation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** Course reservation ID */
    private Long courseReservationId;

    /** Course ID */
    @Excel(name = "Course ID")
    private Long courseId;

    /** User ID */
    @Excel(name = "User ID")
    private Long userId;

    /** Course reservation purpose */
    @Excel(name = "Course reservation purpose")
    private String crPurpose;

    /** Course reservation start time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Course reservation start time", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** Course reservation end time */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Course reservation end time", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** Course reservation status */
    @Excel(name = "Course reservation status")
    private String crStatus;

    public void setCourseReservationId(Long courseReservationId) 
    {
        this.courseReservationId = courseReservationId;
    }

    public Long getCourseReservationId() 
    {
        return courseReservationId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCrPurpose(String crPurpose) 
    {
        this.crPurpose = crPurpose;
    }

    public String getCrPurpose() 
    {
        return crPurpose;
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
    public void setCrStatus(String crStatus) 
    {
        this.crStatus = crStatus;
    }

    public String getCrStatus() 
    {
        return crStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseReservationId", getCourseReservationId())
            .append("courseId", getCourseId())
            .append("userId", getUserId())
            .append("crPurpose", getCrPurpose())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("crStatus", getCrStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
