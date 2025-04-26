package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.system.domain.vo.RouterVo;

/**
 * Menu Business Layer
 *
 * @author Tianyang Pan
 */
public interface ISysMenuService
{
    /**
     * Query system menu list by user
     *
     * @param userId User ID
     * @return Menu list
     */
    public List<SysMenu> selectMenuList(Long userId);

    /**
     * Query system menu list by user and conditions
     *
     * @param menu Menu information
     * @param userId User ID
     * @return Menu list
     */
    public List<SysMenu> selectMenuList(SysMenu menu, Long userId);

    /**
     * Query user permissions by ID
     *
     * @param userId User ID
     * @return Permission list
     */
    public Set<String> selectMenuPermsByUserId(Long userId);

    /**
     * Query role permissions by ID
     *
     * @param roleId Role ID
     * @return Permission list
     */
    public Set<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * Query user menu tree
     *
     * @param userId User ID
     * @return Menu list
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * Query menu list by role ID
     *
     * @param roleId Role ID
     * @return Selected menu IDs
     */
    public List<Long> selectMenuListByRoleId(Long roleId);

    /**
     * Build frontend routing menus
     *
     * @param menus Menu list
     * @return Routing list
     */
    public List<RouterVo> buildMenus(List<SysMenu> menus);

    /**
     * Build frontend menu tree structure
     *
     * @param menus Menu list
     * @return Tree structure
     */
    public List<SysMenu> buildMenuTree(List<SysMenu> menus);

    /**
     * Build frontend dropdown tree
     *
     * @param menus Menu list
     * @return Dropdown tree
     */
    public List<TreeSelect> buildMenuTreeSelect(List<SysMenu> menus);

    /**
     * Query menu by ID
     *
     * @param menuId Menu ID
     * @return Menu information
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * Check if menu has sub-nodes
     *
     * @param menuId Menu ID
     * @return true=has sub-nodes, false=no
     */
    public boolean hasChildByMenuId(Long menuId);

    /**
     * Check if menu is assigned to roles
     *
     * @param menuId Menu ID
     * @return true=assigned, false=not assigned
     */
    public boolean checkMenuExistRole(Long menuId);

    /**
     * Insert menu
     *
     * @param menu Menu information
     * @return Result
     */
    public int insertMenu(SysMenu menu);

    /**
     * Update menu
     *
     * @param menu Menu information
     * @return Result
     */
    public int updateMenu(SysMenu menu);

    /**
     * Delete menu by ID
     *
     * @param menuId Menu ID
     * @return Result
     */
    public int deleteMenuById(Long menuId);

    /**
     * Check if menu name is unique
     *
     * @param menu Menu information
     * @return Result
     */
    public boolean checkMenuNameUnique(SysMenu menu);
}