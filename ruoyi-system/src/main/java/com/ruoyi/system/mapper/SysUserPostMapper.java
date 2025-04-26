package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysUserPost;

/**
 * User-post relationship data layer
 */
public interface SysUserPostMapper
{
    /**
     * Delete user-post relationships by user ID
     */
    public int deleteUserPostByUserId(Long userId);

    /**
     * Count number of user-post relationships by post ID
     */
    public int countUserPostById(Long postId);

    /**
     * Batch delete user-post relationships by IDs
     */
    public int deleteUserPost(Long[] ids);

    /**
     * Batch add user-post relationships
     */
    public int batchUserPost(List<SysUserPost> userPostList);
}
