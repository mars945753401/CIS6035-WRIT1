package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleDept;

/**
 * Role-department association data layer
 *
 * @author Tianyang Pan
 */
public interface SysRoleDeptMapper
{
    /**
     * Delete role-department by role ID
     *
     * @param roleId Role ID
     * @return Result
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * Batch delete role-department
     *
     * @param ids IDs to delete
     * @return Result
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * Count department usage
     *
     * @param deptId Department ID
     * @return Result
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * Batch insert role-department
     *
     * @param roleDeptList Role-department list
     * @return Result
     */
    public int batchRoleDept(List<SysRoleDept> roleDeptList);
}