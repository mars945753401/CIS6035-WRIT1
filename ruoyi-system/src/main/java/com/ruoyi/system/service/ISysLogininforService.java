package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysLogininfor;

/**
 * System Access Log Service Layer
 *
 * @author Tianyang Pan
 */
public interface ISysLogininforService
{
    /**
     * Add system login log
     *
     * @param logininfor Access log object
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * Query system login log collection
     *
     * @param logininfor Access log object
     * @return Login record collection
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * Batch delete login logs
     *
     * @param infoIds Login log IDs to delete
     * @return Result
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * Clear system login logs
     */
    public void cleanLogininfor();
}