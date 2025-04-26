package com.ruoyi.resource.mapper;

import java.util.List;
import com.ruoyi.resource.domain.GrsEquip;

/**
 * EquipmentMapper interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface GrsEquipMapper {

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
     * Delete equipment
     */
    public int deleteGrsEquipByEquipId(Long equipId);

    /**
     * Batch delete equipment by IDs
     */
    public int deleteGrsEquipByEquipIds(Long[] equipIds);
}
