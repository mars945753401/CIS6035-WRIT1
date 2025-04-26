package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRoleMenu;

/**
 * Role-menu association data layer
 *
 * @author Tianyang Pan
 */
public interface SysRoleMenuMapper
{
    /**
     * Check menu usage count
     *
     * @param menuId Menu ID
     * @return Result
     */
    public int checkMenuExistRole(Long menuId);

    /**
     * Delete role-menu by role ID
     *
     * @param roleId Role ID
     * @return Result
     */
    public int deleteRoleMenuByRoleId(Long roleId);

    /**
     * Batch delete role-menu
     *
     * @param ids IDs to delete
     * @return Result
     */
    public int deleteRoleMenu(Long[] ids);

    /**
     * Batch insert role-menu
     *
     * @param roleMenuList Role-menu list
     * @return Result
     */
    public int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}
