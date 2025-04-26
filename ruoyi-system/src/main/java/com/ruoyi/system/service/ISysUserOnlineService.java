package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.system.domain.SysUserOnline;

/**
 * Online User Service Layer
 *
 * @author Tianyang Pan
 */
public interface ISysUserOnlineService
{
    /**
     * Query online user by IP
     *
     * @param ipaddr Login IP
     * @param user User information
     * @return Online user information
     */
    public SysUserOnline selectOnlineByIpaddr(String ipaddr, LoginUser user);

    /**
     * Query online user by username
     *
     * @param userName Username
     * @param user User information
     * @return Online user information
     */
    public SysUserOnline selectOnlineByUserName(String userName, LoginUser user);

    /**
     * Query online user by IP/username
     *
     * @param ipaddr Login IP
     * @param userName Username
     * @param user User information
     * @return Online user information
     */
    public SysUserOnline selectOnlineByInfo(String ipaddr, String userName, LoginUser user);

    /**
     * Convert login user to online user
     *
     * @param user User information
     * @return Online user
     */
    public SysUserOnline loginUserToUserOnline(LoginUser user);
}