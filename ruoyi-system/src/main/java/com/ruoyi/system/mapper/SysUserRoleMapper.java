package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.system.domain.SysUserRole;

/**
 * User-role relationship data layer
 * 
 * @author Tianyang Pan
 */
public interface SysUserRoleMapper
{
    /**
     * Delete user-role relationships by user ID
     */
    public int deleteUserRoleByUserId(Long userId);

    /**
     * Batch delete user-role relationships by IDs
     */
    public int deleteUserRole(Long[] ids);

    /**
     * Count number of user-role relationships by role ID
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * Batch add user-role relationships
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    /**
     * Delete user-role relationship
     */
    public int deleteUserRoleInfo(SysUserRole userRole);

    /**
     * Batch delete user-role relationships
     */
    public int deleteUserRoleInfos(@Param("roleId") Long roleId, @Param("userIds") Long[] userIds);
}
