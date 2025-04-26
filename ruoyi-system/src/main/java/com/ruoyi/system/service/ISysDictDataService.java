package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * Dictionary Business Layer
 *
 * @author Tianyang Pan
 */
public interface ISysDictDataService
{
    /**
     * Query dictionary data by paginated conditions
     *
     * @param dictData Dictionary data information
     * @return Dictionary data collection
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * Query dictionary label by dictionary type and key value
     *
     * @param dictType Dictionary type
     * @param dictValue Dictionary key value
     * @return Dictionary label
     */
    public String selectDictLabel(String dictType, String dictValue);

    /**
     * Query dictionary data by ID
     *
     * @param dictCode Dictionary data ID
     * @return Dictionary data
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * Batch delete dictionary data
     *
     * @param dictCodes Dictionary data IDs to delete
     */
    public void deleteDictDataByIds(Long[] dictCodes);

    /**
     * Insert dictionary data
     *
     * @param dictData Dictionary data information
     * @return Result
     */
    public int insertDictData(SysDictData dictData);

    /**
     * Update dictionary data
     *
     * @param dictData Dictionary data information
     * @return Result
     */
    public int updateDictData(SysDictData dictData);
}