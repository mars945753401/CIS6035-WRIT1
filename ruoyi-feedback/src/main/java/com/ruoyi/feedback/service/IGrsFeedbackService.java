package com.ruoyi.feedback.service;

import java.util.List;
import com.ruoyi.feedback.domain.GrsFeedback;

/**
 * FeedbackService interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface IGrsFeedbackService {

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
     * Batch delete feedback by IDs
     */
    public int deleteGrsFeedbackByFeedbackIds(Long[] feedbackIds);

    /**
     * Delete feedback by ID
     */
    public int deleteGrsFeedbackByFeedbackId(Long feedbackId);
}
