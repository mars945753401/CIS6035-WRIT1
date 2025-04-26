package com.ruoyi.resource.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * GrsCourse class
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public class GrsCourse extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** Course ID */
    private Long courseId;

    /** Course name */
    @Excel(name = "Course name")
    private String courseName;

    /** Course type */
    @Excel(name = "Course type")
    private String courseType;

    /** Course teacher */
    @Excel(name = "Course teacher")
    private String teacher;

    /** Course release date */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "Course release date", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    /** Course description */
    @Excel(name = "Course description")
    private String courseDesc;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseType(String courseType) 
    {
        this.courseType = courseType;
    }

    public String getCourseType() 
    {
        return courseType;
    }
    public void setTeacher(String teacher) 
    {
        this.teacher = teacher;
    }

    public String getTeacher() 
    {
        return teacher;
    }
    public void setReleaseDate(Date releaseDate) 
    {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() 
    {
        return releaseDate;
    }
    public void setCourseDesc(String courseDesc) 
    {
        this.courseDesc = courseDesc;
    }

    public String getCourseDesc() 
    {
        return courseDesc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("courseType", getCourseType())
            .append("teacher", getTeacher())
            .append("releaseDate", getReleaseDate())
            .append("courseDesc", getCourseDesc())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
