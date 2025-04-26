package com.ruoyi.reservation.mapper;

import java.util.List;
import com.ruoyi.reservation.domain.GrsEquipReservation;

/**
 * Equipment ReservationMapper interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface GrsEquipReservationMapper {

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
     * Delete equipment reservation by ID
     */
    public int deleteGrsEquipReservationByEquipReservationId(Long equipReservationId);

    /**
     * Batch delete equipment reservation by IDs
     */
    public int deleteGrsEquipReservationByEquipReservationIds(Long[] equipReservationIds);
}
