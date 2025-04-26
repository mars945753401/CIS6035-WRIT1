package com.ruoyi.resource.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resource.mapper.GrsEquipMapper;
import com.ruoyi.resource.domain.GrsEquip;
import com.ruoyi.resource.service.IGrsEquipService;

/**
 * EquipmentService implementation
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@Service
public class GrsEquipServiceImpl implements IGrsEquipService {

    @Autowired
    private GrsEquipMapper grsEquipMapper;

    /**
     * Search equipment by ID
     */
    @Override
    public GrsEquip selectGrsEquipByEquipId(Long equipId) {
        return grsEquipMapper.selectGrsEquipByEquipId(equipId);
    }

    /**
     * Search equipment list
     */
    @Override
    public List<GrsEquip> selectGrsEquipList(GrsEquip grsEquip) {
        return grsEquipMapper.selectGrsEquipList(grsEquip);
    }

    /**
     * Add equipment
     */
    @Override
    public int insertGrsEquip(GrsEquip grsEquip) {
        grsEquip.setCreateTime(DateUtils.getNowDate());
        return grsEquipMapper.insertGrsEquip(grsEquip);
    }

    /**
     * Update equipment
     */
    @Override
    public int updateGrsEquip(GrsEquip grsEquip) {
        grsEquip.setUpdateTime(DateUtils.getNowDate());
        return grsEquipMapper.updateGrsEquip(grsEquip);
    }

    /**
     * Batch delete equipment by IDs
     */
    @Override
    public int deleteGrsEquipByEquipIds(Long[] equipIds) {
        return grsEquipMapper.deleteGrsEquipByEquipIds(equipIds);
    }

    /**
     * Delete equipment by ID
     */
    @Override
    public int deleteGrsEquipByEquipId(Long equipId) {
        return grsEquipMapper.deleteGrsEquipByEquipId(equipId);
    }
}
