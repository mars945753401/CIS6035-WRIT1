package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * Dictionary table data layer
 *
 * @author Tianyang Pan
 */
public interface SysDictDataMapper
{
    /**
     * Query dictionary data by condition with paging
     *
     * @param dictData Dictionary data info
     * @return Dictionary data collection info
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * Query dictionary data by dictionary type
     *
     * @param dictType Dictionary type
     * @return Dictionary data collection info
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * Query dictionary label by type and key
     *
     * @param dictType Dictionary type
     * @param dictValue Dictionary key value
     * @return Dictionary label
     */
    public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

    /**
     * Query dictionary data by ID
     *
     * @param dictCode Dictionary data ID
     * @return Dictionary data
     */
    public SysDictData selectDictDataById(Long dictCode);

    /**
     * Count dictionary data by type
     *
     * @param dictType Dictionary type
     * @return Count result
     */
    public int countDictDataByType(String dictType);

    /**
     * Delete dictionary data by ID
     *
     * @param dictCode Dictionary data ID
     * @return Result
     */
    public int deleteDictDataById(Long dictCode);

    /**
     * Batch delete dictionary data
     *
     * @param dictCodes IDs to delete
     * @return Result
     */
    public int deleteDictDataByIds(Long[] dictCodes);

    /**
     * Insert dictionary data
     *
     * @param dictData Dictionary data info
     * @return Result
     */
    public int insertDictData(SysDictData dictData);

    /**
     * Update dictionary data
     *
     * @param dictData Dictionary data info
     * @return Result
     */
    public int updateDictData(SysDictData dictData);

    /**
     * Synchronize dictionary type modification
     *
     * @param oldDictType Old dictionary type
     * @param newDictType New dictionary type
     * @return Result
     */
    public int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);
}