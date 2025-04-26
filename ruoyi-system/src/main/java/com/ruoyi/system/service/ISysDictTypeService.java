package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * Dictionary Business Layer
 *
 * @author Tianyang Pan
 */
public interface ISysDictTypeService
{
    /**
     * Query dictionary types by paginated conditions
     *
     * @param dictType Dictionary type information
     * @return Dictionary type collection
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * Query all dictionary types
     *
     * @return Dictionary type collection
     */
    public List<SysDictType> selectDictTypeAll();

    /**
     * Query dictionary data by type
     *
     * @param dictType Dictionary type
     * @return Dictionary data collection
     */
    public List<SysDictData> selectDictDataByType(String dictType);

    /**
     * Query dictionary type by ID
     *
     * @param dictId Dictionary type ID
     * @return Dictionary type
     */
    public SysDictType selectDictTypeById(Long dictId);

    /**
     * Query dictionary type by type
     *
     * @param dictType Dictionary type
     * @return Dictionary type
     */
    public SysDictType selectDictTypeByType(String dictType);

    /**
     * Batch delete dictionary types
     *
     * @param dictIds Dictionary IDs to delete
     */
    public void deleteDictTypeByIds(Long[] dictIds);

    /**
     * Load dictionary cache data
     */
    public void loadingDictCache();

    /**
     * Clear dictionary cache data
     */
    public void clearDictCache();

    /**
     * Reset dictionary cache data
     */
    public void resetDictCache();

    /**
     * Insert dictionary type
     *
     * @param dictType Dictionary type information
     * @return Result
     */
    public int insertDictType(SysDictType dictType);

    /**
     * Update dictionary type
     *
     * @param dictType Dictionary type information
     * @return Result
     */
    public int updateDictType(SysDictType dictType);

    /**
     * Check if dictionary type name is unique
     *
     * @param dictType Dictionary type
     * @return Result
     */
    public boolean checkDictTypeUnique(SysDictType dictType);
}