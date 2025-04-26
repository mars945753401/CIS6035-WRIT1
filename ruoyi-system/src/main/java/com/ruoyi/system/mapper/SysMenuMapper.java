package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysMenu;

/**
 * Menu table data layer
 *
 * @author Tianyang Pan
 */
public interface SysMenuMapper
{
    /**
     * Query system menu list
     *
     * @param menu Menu info
     * @return Menu list
     */
    public List<SysMenu> selectMenuList(SysMenu menu);

    /**
     * Query all permissions
     *
     * @return Permission list
     */
    public List<String> selectMenuPerms();

    /**
     * Query menu list by user
     *
     * @param menu Menu info
     * @return Menu list
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);

    /**
     * Query permissions by role ID
     *
     * @param roleId Role ID
     * @return Permission list
     */
    public List<String> selectMenuPermsByRoleId(Long roleId);

    /**
     * Query permissions by user ID
     *
     * @param userId User ID
     * @return Permission list
     */
    public List<String> selectMenuPermsByUserId(Long userId);

    /**
     * Query all menu tree
     *
     * @return Menu list
     */
    public List<SysMenu> selectMenuTreeAll();

    /**
     * Query menu tree by user ID
     *
     * @param userId User ID
     * @return Menu list
     */
    public List<SysMenu> selectMenuTreeByUserId(Long userId);

    /**
     * Query menu list by role ID
     *
     * @param roleId Role ID
     * @param menuCheckStrictly Whether to check strictly
     * @return Selected menu list
     */
    public List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);

    /**
     * Query menu by ID
     *
     * @param menuId Menu ID
     * @return Menu info
     */
    public SysMenu selectMenuById(Long menuId);

    /**
     * Check if has child menus
     *
     * @param menuId Menu ID
     * @return Result
     */
    public int hasChildByMenuId(Long menuId);

    /**
     * Insert menu
     *
     * @param menu Menu info
     * @return Result
     */
    public int insertMenu(SysMenu menu);

    /**
     * Update menu
     *
     * @param menu Menu info
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
     * Check menu name uniqueness
     *
     * @param menuName Menu name
     * @param parentId Parent menu ID
     * @return Result
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);
}
