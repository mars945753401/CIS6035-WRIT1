package com.ruoyi.reservation.mapper;

import java.util.List;
import com.ruoyi.reservation.domain.GrsCourseReservation;

/**
 * Course ReservationMapper interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface GrsCourseReservationMapper {

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
     * Delete course reservation by ID
     */
    public int deleteGrsCourseReservationByCourseReservationId(Long courseReservationId);

    /**
     * Batch delete course reservation by IDs
     */
    public int deleteGrsCourseReservationByCourseReservationIds(Long[] courseReservationIds);
}
