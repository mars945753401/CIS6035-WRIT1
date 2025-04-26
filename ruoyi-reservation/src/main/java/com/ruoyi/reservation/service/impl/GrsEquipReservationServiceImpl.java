package com.ruoyi.reservation.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.reservation.mapper.GrsEquipReservationMapper;
import com.ruoyi.reservation.domain.GrsEquipReservation;
import com.ruoyi.reservation.service.IGrsEquipReservationService;

/**
 * Equipment ReservationService implementation
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@Service
public class GrsEquipReservationServiceImpl implements IGrsEquipReservationService {

    @Autowired
    private GrsEquipReservationMapper grsEquipReservationMapper;

    /**
     * Search equipment reservation by ID
     */
    @Override
    public GrsEquipReservation selectGrsEquipReservationByEquipReservationId(Long equipReservationId) {
        return grsEquipReservationMapper.selectGrsEquipReservationByEquipReservationId(equipReservationId);
    }

    /**
     * Search equipment reservation list
     */
    @Override
    public List<GrsEquipReservation> selectGrsEquipReservationList(GrsEquipReservation grsEquipReservation) {
        return grsEquipReservationMapper.selectGrsEquipReservationList(grsEquipReservation);
    }

    /**
     * Add equipment reservation
     */
    @Override
    public int insertGrsEquipReservation(GrsEquipReservation grsEquipReservation) {
        grsEquipReservation.setCreateTime(DateUtils.getNowDate());
        grsEquipReservation.setCreateBy(SecurityUtils.getUsername());
        grsEquipReservation.setErStatus("submitted");
        return grsEquipReservationMapper.insertGrsEquipReservation(grsEquipReservation);
    }

    /**
     * Update equipment reservation
     */
    @Override
    public int updateGrsEquipReservation(GrsEquipReservation grsEquipReservation) {
        grsEquipReservation.setUpdateTime(DateUtils.getNowDate());
        grsEquipReservation.setUpdateBy(SecurityUtils.getUsername());
        return grsEquipReservationMapper.updateGrsEquipReservation(grsEquipReservation);
    }

    /**
     * Batch delete equipment reservation by IDs
     */
    @Override
    public int deleteGrsEquipReservationByEquipReservationIds(Long[] equipReservationIds) {
        return grsEquipReservationMapper.deleteGrsEquipReservationByEquipReservationIds(equipReservationIds);
    }

    /**
     * Delete equipment reservation by ID
     */
    @Override
    public int deleteGrsEquipReservationByEquipReservationId(Long equipReservationId) {
        return grsEquipReservationMapper.deleteGrsEquipReservationByEquipReservationId(equipReservationId);
    }
}
