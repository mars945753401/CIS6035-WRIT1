package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.domain.SysUserRole;

/**
 * Role Business Layer
 *
 * @author Tianyang Pan
 */
public interface ISysRoleService
{
    /**
     * Query roles by paginated conditions
     *
     * @param role Role information
     * @return Role list
     */
    public List<SysRole> selectRoleList(SysRole role);

    /**
     * Query user roles by user ID
     *
     * @param userId User ID
     * @return Role list
     */
    public List<SysRole> selectRolesByUserId(Long userId);

    /**
     * Query user role permissions
     *
     * @param userId User ID
     * @return Permissions
     */
    public Set<String> selectRolePermissionByUserId(Long userId);

    /**
     * Query all roles
     *
     * @return Role list
     */
    public List<SysRole> selectRoleAll();

    /**
     * Query user's selected role IDs
     *
     * @param userId User ID
     * @return Selected role IDs
     */
    public List<Long> selectRoleListByUserId(Long userId);

    /**
     * Query role by ID
     *
     * @param roleId Role ID
     * @return Role information
     */
    public SysRole selectRoleById(Long roleId);

    /**
     * Check role name uniqueness
     *
     * @param role Role information
     * @return true=unique, false=not unique
     */
    public boolean checkRoleNameUnique(SysRole role);

    /**
     * Check role key uniqueness
     *
     * @param role Role information
     * @return true=unique, false=not unique
     */
    public boolean checkRoleKeyUnique(SysRole role);

    /**
     * Validate role operation permissions
     *
     * @param role Role information
     */
    public void checkRoleAllowed(SysRole role);

    /**
     * Validate role data permissions
     *
     * @param roleIds Role IDs
     */
    public void checkRoleDataScope(Long... roleIds);

    /**
     * Count users assigned to a role
     *
     * @param roleId Role ID
     * @return User count
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * Insert role
     *
     * @param role Role information
     * @return Result
     */
    public int insertRole(SysRole role);

    /**
     * Update role
     *
     * @param role Role information
     * @return Result
     */
    public int updateRole(SysRole role);

    /**
     * Update role status
     *
     * @param role Role information
     * @return Result
     */
    public int updateRoleStatus(SysRole role);

    /**
     * Update role data permissions
     *
     * @param role Role information
     * @return Result
     */
    public int authDataScope(SysRole role);

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
     * @param roleIds Role IDs to delete
     * @return Result
     */
    public int deleteRoleByIds(Long[] roleIds);

    /**
     * Remove role-user association
     *
     * @param userRole User-role object
     * @return Result
     */
    public int deleteAuthUser(SysUserRole userRole);

    /**
     * Batch remove role-user associations
     *
     * @param roleId Role ID
     * @param userIds User IDs to remove
     * @return Result
     */
    public int deleteAuthUsers(Long roleId, Long[] userIds);

    /**
     * Batch assign users to role
     *
     * @param roleId Role ID
     * @param userIds User IDs to assign
     * @return Result
     */
    public int insertAuthUsers(Long roleId, Long[] userIds);
}