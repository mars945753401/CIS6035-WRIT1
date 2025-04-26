package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysOperLog;

/**
 * Operation log data layer
 *
 * @author Tianyang Pan
 */
public interface SysOperLogMapper
{
    /**
     * Insert operation log
     *
     * @param operLog Operation log object
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * Query operation log list
     *
     * @param operLog Operation log object
     * @return Operation log collection
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * Batch delete operation logs
     *
     * @param operIds IDs to delete
     * @return Result
     */
    public int deleteOperLogByIds(Long[] operIds);

    /**
     * Query operation log details
     *
     * @param operId Operation ID
     * @return Operation log object
     */
    public SysOperLog selectOperLogById(Long operId);

    /**
     * Clean operation logs
     */
    public void cleanOperLog();
}