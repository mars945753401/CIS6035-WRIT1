package com.ruoyi.feedback.mapper;

import java.util.List;
import com.ruoyi.feedback.domain.GrsFeedback;

/**
 * FeedbackMapper interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface GrsFeedbackMapper {

    /**
     * Search feedback by ID
     */
    public GrsFeedback selectGrsFeedbackByFeedbackId(Long feedbackId);

    /**
     * Search feedback list
     */
    public List<GrsFeedback> selectGrsFeedbackList(GrsFeedback grsFeedback);

    /**
     * Add feedback
     */
    public int insertGrsFeedback(GrsFeedback grsFeedback);

    /**
     * Update feedback
     */
    public int updateGrsFeedback(GrsFeedback grsFeedback);

    /**
     * Delete feedback by ID
     */
    public int deleteGrsFeedbackByFeedbackId(Long feedbackId);

    /**
     * Batch delete feedback by IDs
     */
    public int deleteGrsFeedbackByFeedbackIds(Long[] feedbackIds);
}
