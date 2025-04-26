package com.ruoyi.feedback.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feedback.mapper.GrsFeedbackMapper;
import com.ruoyi.feedback.domain.GrsFeedback;
import com.ruoyi.feedback.service.IGrsFeedbackService;

/**
 * FeedbackService implementation
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@Service
public class GrsFeedbackServiceImpl implements IGrsFeedbackService {

    @Autowired
    private GrsFeedbackMapper grsFeedbackMapper;

    /**
     * Search feedback by ID
     */
    @Override
    public GrsFeedback selectGrsFeedbackByFeedbackId(Long feedbackId) {
        return grsFeedbackMapper.selectGrsFeedbackByFeedbackId(feedbackId);
    }

    /**
     * Search feedback list
     */
    @Override
    public List<GrsFeedback> selectGrsFeedbackList(GrsFeedback grsFeedback) {
        return grsFeedbackMapper.selectGrsFeedbackList(grsFeedback);
    }

    /**
     * Add feedback
     */
    @Override
    public int insertGrsFeedback(GrsFeedback grsFeedback) {
        grsFeedback.setCreateTime(DateUtils.getNowDate());
        grsFeedback.setCreateBy(SecurityUtils.getUsername());
        grsFeedback.setFbStatus("submitted");
        return grsFeedbackMapper.insertGrsFeedback(grsFeedback);
    }

    /**
     * Update feedback
     */
    @Override
    public int updateGrsFeedback(GrsFeedback grsFeedback) {
        grsFeedback.setUpdateTime(DateUtils.getNowDate());
        grsFeedback.setUpdateBy(SecurityUtils.getUsername());
        return grsFeedbackMapper.updateGrsFeedback(grsFeedback);
    }

    /**
     * Batch delete feedback by IDs
     */
    @Override
    public int deleteGrsFeedbackByFeedbackIds(Long[] feedbackIds) {
        return grsFeedbackMapper.deleteGrsFeedbackByFeedbackIds(feedbackIds);
    }

    /**
     * Delete feedback by ID
     */
    @Override
    public int deleteGrsFeedbackByFeedbackId(Long feedbackId) {
        return grsFeedbackMapper.deleteGrsFeedbackByFeedbackId(feedbackId);
    }
}
