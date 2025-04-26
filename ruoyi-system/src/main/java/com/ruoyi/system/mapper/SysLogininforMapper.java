package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysLogininfor;

/**
 * System access log data layer
 *
 * @author Tianyang Pan
 */
public interface SysLogininforMapper
{
    /**
     * Insert system login log
     *
     * @param logininfor Access log object
     */
    public void insertLogininfor(SysLogininfor logininfor);

    /**
     * Query login log collection
     *
     * @param logininfor Access log object
     * @return Login record collection
     */
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * Batch delete login logs
     *
     * @param infoIds IDs to delete
     * @return Result
     */
    public int deleteLogininforByIds(Long[] infoIds);

    /**
     * Clean login logs
     *
     * @return Result
     */
    public int cleanLogininfor();
}