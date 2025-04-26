package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * User data layer
 * 
 * @author Tianyang Pan
 */
public interface SysUserMapper
{
    /**
     * Select user list
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * Select allocated user list
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * Select unallocated user list
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * Select user by user name
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * Select user by user ID
     */
    public SysUser selectUserById(Long userId);

    /**
     * Add user
     */
    public int insertUser(SysUser user);

    /**
     * Update user
     */
    public int updateUser(SysUser user);

    /**
     * Update user's avatar
     */
    public int updateUserAvatar(@Param("userName") String userName, @Param("avatar") String avatar);

    /**
     * Reset user's password
     */
    public int resetUserPwd(@Param("userName") String userName, @Param("password") String password);

    /**
     * Delete user by ID
     */
    public int deleteUserById(Long userId);

    /**
     * Batch delete user by IDs
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * Check whether user name is unique
     */
    public SysUser checkUserNameUnique(String userName);

    /**
     * Check whether phonenumber is unique
     */
    public SysUser checkPhoneUnique(String phonenumber);

    /**
     * Check whether email is unique
     */
    public SysUser checkEmailUnique(String email);
}
