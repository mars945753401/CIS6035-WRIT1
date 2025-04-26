package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysConfig;

/**
 * System config interface
 * 
 * @author Tianyang Pan
 */
public interface ISysConfigService
{
    /**
     * Select config by ID
     */
    public SysConfig selectConfigById(Long configId);

    /**
     * Select config by key
     */
    public String selectConfigByKey(String configKey);

    /**
     * Select captcha switch
     */
    public boolean selectCaptchaEnabled();

    /**
     * Select config list
     */
    public List<SysConfig> selectConfigList(SysConfig config);

    /**
     * Insert config
     */
    public int insertConfig(SysConfig config);

    /**
     * Update config
     */
    public int updateConfig(SysConfig config);

    /**
     * Batch delete config by IDs
     */
    public void deleteConfigByIds(Long[] configIds);

    /**
     * Load config cache
     */
    public void loadingConfigCache();

    /**
     * Clear config cache
     */
    public void clearConfigCache();

    /**
     * Reset config cache
     */
    public void resetConfigCache();

    /**
     * Check whether config key is unique
     */
    public boolean checkConfigKeyUnique(SysConfig config);
}
