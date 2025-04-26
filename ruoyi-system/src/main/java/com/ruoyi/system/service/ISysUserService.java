package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * User Business Layer
 *
 * @author Tianyang Pan
 */
public interface ISysUserService
{
    /**
     * Query user list by paginated conditions
     *
     * @param user User information
     * @return User list
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * Query assigned role users
     *
     * @param user User information
     * @return User list
     */
    public List<SysUser> selectAllocatedList(SysUser user);

    /**
     * Query unassigned role users
     *
     * @param user User information
     * @return User list
     */
    public List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * Query user by username
     *
     * @param userName Username
     * @return User object
     */
    public SysUser selectUserByUserName(String userName);

    /**
     * Query user by ID
     *
     * @param userId User ID
     * @return User object
     */
    public SysUser selectUserById(Long userId);

    /**
     * Query user's role group
     *
     * @param userName Username
     * @return Role group
     */
    public String selectUserRoleGroup(String userName);

    /**
     * Query user's post group
     *
     * @param userName Username
     * @return Post group
     */
    public String selectUserPostGroup(String userName);

    /**
     * Check username uniqueness
     *
     * @param user User information
     * @return true=unique, false=not unique
     */
    public boolean checkUserNameUnique(SysUser user);

    /**
     * Check phone uniqueness
     *
     * @param user User information
     * @return true=unique, false=not unique
     */
    public boolean checkPhoneUnique(SysUser user);

    /**
     * Check email uniqueness
     *
     * @param user User information
     * @return true=unique, false=not unique
     */
    public boolean checkEmailUnique(SysUser user);

    /**
     * Validate user operation permissions
     *
     * @param user User information
     */
    public void checkUserAllowed(SysUser user);

    /**
     * Validate user data permissions
     *
     * @param userId User ID
     */
    public void checkUserDataScope(Long userId);

    /**
     * Insert user
     *
     * @param user User information
     * @return Result
     */
    public int insertUser(SysUser user);

    /**
     * Register user
     *
     * @param user User information
     * @return Result
     */
    public boolean registerUser(SysUser user);

    /**
     * Update user
     *
     * @param user User information
     * @return Result
     */
    public int updateUser(SysUser user);

    /**
     * Assign roles to user
     *
     * @param userId User ID
     * @param roleIds Role IDs
     */
    public void insertUserAuth(Long userId, Long[] roleIds);

    /**
     * Update user status
     *
     * @param user User information
     * @return Result
     */
    public int updateUserStatus(SysUser user);

    /**
     * Update user profile
     *
     * @param user User information
     * @return Result
     */
    public int updateUserProfile(SysUser user);

    /**
     * Update user avatar
     *
     * @param userName Username
     * @param avatar Avatar URL
     * @return Result
     */
    public boolean updateUserAvatar(String userName, String avatar);

    /**
     * Reset user password
     *
     * @param user User information
     * @return Result
     */
    public int resetPwd(SysUser user);

    /**
     * Reset user password
     *
     * @param userName Username
     * @param password New password
     * @return Result
     */
    public int resetUserPwd(String userName, String password);

    /**
     * Delete user by ID
     *
     * @param userId User ID
     * @return Result
     */
    public int deleteUserById(Long userId);

    /**
     * Batch delete users
     *
     * @param userIds User IDs to delete
     * @return Result
     */
    public int deleteUserByIds(Long[] userIds);

    /**
     * Import user data
     *
     * @param userList User list
     * @param isUpdateSupport Allow updates
     * @param operName Operator name
     * @return Result message
     */
    public String importUser(List<SysUser> userList, Boolean isUpdateSupport, String operName);
}