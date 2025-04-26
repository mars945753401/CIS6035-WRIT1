package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysRole;

/**
 * Role table data layer
 *
 * @author Tianyang Pan
 */
public interface SysRoleMapper
{
    /**
     * Query roles with paging
     *
     * @param role Role info
     * @return Role collection
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * Query user roles
     *
     * @param userId User ID
     * @return Role list
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);

    /**
     * Query all roles
     *
     * @return Role list
     */
    public List<SysRole> selectRoleAll();

    /**
     * Get user role selection
     *
     * @param userId User ID
     * @return Selected role IDs
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * Query role by ID
     *
     * @param roleId Role ID
     * @return Role info
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * Query user roles
     *
     * @param userName Username
     * @return Role list
     */
    public List<SysRole> selectRolesByUserName(String userName);

    /**
     * Check role name uniqueness
     *
     * @param roleName Role name
     * @return Role info
     */
    public SysRole checkRoleNameUnique(String roleName);

    /**
     * Check role key uniqueness
     *
     * @param roleKey Role key
     * @return Role info
     */
    public SysRole checkRoleKeyUnique(String roleKey);

    /**
     * Update role
     *
     * @param role Role info
     * @return Result
     */
    public int updateRole(SysRole role);

    /**
     * Insert role
     *
     * @param role Role info
     * @return Result
     */
    public int insertRole(SysRole role);

    /**
     * Delete role by ID
     *
     * @param roleId Role ID
     * @return Result
     */
    public int deleteRoleById(Long roleId);

    /**
     * Batch delete roles
     *
     * @param roleIds IDs to delete
     * @return Result
     */
    public int deleteRoleByIds(Long[] roleIds);
}