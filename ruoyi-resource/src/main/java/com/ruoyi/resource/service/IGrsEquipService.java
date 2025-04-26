package com.ruoyi.resource.service;

import java.util.List;
import com.ruoyi.resource.domain.GrsEquip;

/**
 * EquipmentService接口
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface IGrsEquipService {

    /**
     * Search equipment by ID
     */
    public GrsEquip selectGrsEquipByEquipId(Long equipId);

    /**
     * Search equipment list
     */
    public List<GrsEquip> selectGrsEquipList(GrsEquip grsEquip);

    /**
     * Add equipment
     */
    public int insertGrsEquip(GrsEquip grsEquip);

    /**
     * Update equipment
     */
    public int updateGrsEquip(GrsEquip grsEquip);

    /**
     * Batch delete equipment by IDs
     */
    public int deleteGrsEquipByEquipIds(Long[] equipIds);

    /**
     * Delete equipment by ID
     */
    public int deleteGrsEquipByEquipId(Long equipId);
}
