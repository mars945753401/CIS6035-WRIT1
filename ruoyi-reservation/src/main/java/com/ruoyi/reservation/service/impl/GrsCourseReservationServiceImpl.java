package com.ruoyi.reservation.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.reservation.mapper.GrsCourseReservationMapper;
import com.ruoyi.reservation.domain.GrsCourseReservation;
import com.ruoyi.reservation.service.IGrsCourseReservationService;

/**
 * Course ReservationService implementation
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@Service
public class GrsCourseReservationServiceImpl implements IGrsCourseReservationService {

    @Autowired
    private GrsCourseReservationMapper grsCourseReservationMapper;

    /**
     * Search course reservation by ID
     */
    @Override
    public GrsCourseReservation selectGrsCourseReservationByCourseReservationId(Long courseReservationId) {
        return grsCourseReservationMapper.selectGrsCourseReservationByCourseReservationId(courseReservationId);
    }

    /**
     * Search course reservation list
     */
    @Override
    public List<GrsCourseReservation> selectGrsCourseReservationList(GrsCourseReservation grsCourseReservation) {
        return grsCourseReservationMapper.selectGrsCourseReservationList(grsCourseReservation);
    }

    /**
     * Add course reservation
     */
    @Override
    public int insertGrsCourseReservation(GrsCourseReservation grsCourseReservation) {
        grsCourseReservation.setCreateTime(DateUtils.getNowDate());
        grsCourseReservation.setCreateBy(SecurityUtils.getUsername());
        grsCourseReservation.setCrStatus("submitted");
        return grsCourseReservationMapper.insertGrsCourseReservation(grsCourseReservation);
    }

    /**
     * Update course reservation
     */
    @Override
    public int updateGrsCourseReservation(GrsCourseReservation grsCourseReservation) {
        grsCourseReservation.setUpdateTime(DateUtils.getNowDate());
        grsCourseReservation.setUpdateBy(SecurityUtils.getUsername());
        return grsCourseReservationMapper.updateGrsCourseReservation(grsCourseReservation);
    }

    /**
     * Batch delete course reservation by IDs
     */
    @Override
    public int deleteGrsCourseReservationByCourseReservationIds(Long[] courseReservationIds) {
        return grsCourseReservationMapper.deleteGrsCourseReservationByCourseReservationIds(courseReservationIds);
    }

    /**
     * Delete course reservation by ID
     */
    @Override
    public int deleteGrsCourseReservationByCourseReservationId(Long courseReservationId) {
        return grsCourseReservationMapper.deleteGrsCourseReservationByCourseReservationId(courseReservationId);
    }
}
