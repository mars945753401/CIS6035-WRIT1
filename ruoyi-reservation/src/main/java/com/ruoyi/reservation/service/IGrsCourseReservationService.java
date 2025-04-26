package com.ruoyi.reservation.service;

import java.util.List;
import com.ruoyi.reservation.domain.GrsCourseReservation;

/**
 * Course ReservationService interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface IGrsCourseReservationService {

    /**
     * Search course reservation by ID
     */
    public GrsCourseReservation selectGrsCourseReservationByCourseReservationId(Long courseReservationId);

    /**
     * Search course reservation list
     */
    public List<GrsCourseReservation> selectGrsCourseReservationList(GrsCourseReservation grsCourseReservation);

    /**
     * Add course reservation
     */
    public int insertGrsCourseReservation(GrsCourseReservation grsCourseReservation);

    /**
     * Update course reservation
     */
    public int updateGrsCourseReservation(GrsCourseReservation grsCourseReservation);

    /**
     * Batch delete course reservation by Ids
     */
    public int deleteGrsCourseReservationByCourseReservationIds(Long[] courseReservationIds);

    /**
     * Delete course reservation
     */
    public int deleteGrsCourseReservationByCourseReservationId(Long courseReservationId);
}
