package com.ruoyi.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Post
 * 
 * @author Tianyang Pan
 */
public class SysPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** Post ID */
    @Excel(name = "Post ID", cellType = ColumnType.NUMERIC)
    private Long postId;

    /** Post code */
    @Excel(name = "Post code")
    private String postCode;

    /** Post name */
    @Excel(name = "name")
    private String postName;

    /** Post sort */
    @Excel(name = "Post sort")
    private Integer postSort;

    /** Status (0-Normal, 1-abnormal) */
    @Excel(name = "Status (0-Normal, 1-abnormal)")
    private String status;

    /** Is user has the post flag (default is false) */
    private boolean flag = false;

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    @NotBlank(message = "Post code cannot be empty")
    @Size(min = 0, max = 64, message = "Length of post code cannot more than 64")
    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    @NotBlank(message = "Post name cannot be empty")
    @Size(min = 0, max = 50, message = "Length of post name cannot more than 50")
    public String getPostName()
    {
        return postName;
    }

    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    @NotNull(message = "Post sort cannot be empty")
    public Integer getPostSort()
    {
        return postSort;
    }

    public void setPostSort(Integer postSort)
    {
        this.postSort = postSort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
