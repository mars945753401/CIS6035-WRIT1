package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * Dictionary table data layer
 *
 * @author Tianyang Pan
 */
public interface SysDictTypeMapper
{
    /**
     * Query dictionary types with paging
     *
     * @param dictType Dictionary type info
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
     * Delete dictionary type by ID
     *
     * @param dictId Dictionary ID
     * @return Result
     */
    public int deleteDictTypeById(Long dictId);

    /**
     * Batch delete dictionary types
     *
     * @param dictIds IDs to delete
     * @return Result
     */
    public int deleteDictTypeByIds(Long[] dictIds);

    /**
     * Insert dictionary type
     *
     * @param dictType Dictionary type info
     * @return Result
     */
    public int insertDictType(SysDictType dictType);

    /**
     * Update dictionary type
     *
     * @param dictType Dictionary type info
     * @return Result
     */
    public int updateDictType(SysDictType dictType);

    /**
     * Check if dictionary type is unique
     *
     * @param dictType Dictionary type
     * @return Result
     */
    public SysDictType checkDictTypeUnique(String dictType);
}