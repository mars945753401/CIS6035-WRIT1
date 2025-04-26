package com.ruoyi.feedback.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * GrsFeedback class
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public class GrsFeedback extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** Feedback ID */
    private Long feedbackId;

    /** User ID */
    @Excel(name = "User ID")
    private Long userId;

    /** Feedback score */
    @Excel(name = "Feedback score")
    private BigDecimal fbScore;

    /** Feedback content */
    @Excel(name = "Feedback content")
    private String fbContent;

    /** Feedback reply */
    @Excel(name = "Feedback reply")
    private String fbReply;

    /** Feedback status */
    @Excel(name = "Feedback status")
    private String fbStatus;

    public void setFeedbackId(Long feedbackId) 
    {
        this.feedbackId = feedbackId;
    }

    public Long getFeedbackId() 
    {
        return feedbackId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setFbScore(BigDecimal fbScore) 
    {
        this.fbScore = fbScore;
    }

    public BigDecimal getFbScore() 
    {
        return fbScore;
    }
    public void setFbContent(String fbContent) 
    {
        this.fbContent = fbContent;
    }

    public String getFbContent() 
    {
        return fbContent;
    }
    public void setFbReply(String fbReply) 
    {
        this.fbReply = fbReply;
    }

    public String getFbReply() 
    {
        return fbReply;
    }
    public void setFbStatus(String fbStatus) 
    {
        this.fbStatus = fbStatus;
    }

    public String getFbStatus() 
    {
        return fbStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("feedbackId", getFeedbackId())
            .append("userId", getUserId())
            .append("fbScore", getFbScore())
            .append("fbContent", getFbContent())
            .append("fbReply", getFbReply())
            .append("fbStatus", getFbStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
