package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysConfig;

/**
 * System config mapper
 * 
 * @author Tianyang Pan
 */
public interface SysConfigMapper
{
    /**
     * Select config
     */
    public SysConfig selectConfig(SysConfig config);

    /**
     * Select config by ID
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * Select config list
     */
    public List<SysConfig> selectConfigList(SysConfig config);

    /**
     * Select config by config key
     */
    public SysConfig checkConfigKeyUnique(String configKey);

    /**
     * Add config
     */
    public int insertConfig(SysConfig config);

    /**
     * Update config
     */
    public int updateConfig(SysConfig config);

    /**
     * Delet config by ID
     */
    public int deleteConfigById(Long configId);

    /**
     * Batch delete config by IDs
     */
    public int deleteConfigByIds(Long[] configIds);
}
