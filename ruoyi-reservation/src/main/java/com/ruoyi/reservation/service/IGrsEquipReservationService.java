package com.ruoyi.reservation.service;

import java.util.List;
import com.ruoyi.reservation.domain.GrsEquipReservation;

/**
 * Equipment ReservationService interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface IGrsEquipReservationService {

    /**
     * Search equipment reservation by ID
     */
    public GrsEquipReservation selectGrsEquipReservationByEquipReservationId(Long equipReservationId);

    /**
     * Search equipment reservation list
     */
    public List<GrsEquipReservation> selectGrsEquipReservationList(GrsEquipReservation grsEquipReservation);

    /**
     * Add equipment reservation
     */
    public int insertGrsEquipReservation(GrsEquipReservation grsEquipReservation);

    /**
     * Update equipment reservation
     */
    public int updateGrsEquipReservation(GrsEquipReservation grsEquipReservation);

    /**
     * Batch delete equipment reservation by IDs
     */
    public int deleteGrsEquipReservationByEquipReservationIds(Long[] equipReservationIds);

    /**
     * Delete equipment reservation by ID
     */
    public int deleteGrsEquipReservationByEquipReservationId(Long equipReservationId);
}
