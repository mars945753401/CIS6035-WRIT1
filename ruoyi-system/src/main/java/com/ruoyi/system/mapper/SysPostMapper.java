package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * Post information data layer
 *
 * @author Tianyang Pan
 */
public interface SysPostMapper
{
    /**
     * Query post list
     *
     * @param post Post info
     * @return Post collection
     */
    public List<SysPost> selectPostList(SysPost post);

    /**
     * Query all posts
     *
     * @return Post list
     */
    public List<SysPost> selectPostAll();

    /**
     * Query post by ID
     *
     * @param postId Post ID
     * @return Post info
     */
    public SysPost selectPostById(Long postId);

    /**
     * Get user post selection
     *
     * @param userId User ID
     * @return Selected post IDs
     */
    public List<Long> selectPostListByUserId(Long userId);

    /**
     * Query user posts
     *
     * @param userName Username
     * @return Result
     */
    public List<SysPost> selectPostsByUserName(String userName);

    /**
     * Delete post by ID
     *
     * @param postId Post ID
     * @return Result
     */
    public int deletePostById(Long postId);

    /**
     * Batch delete posts
     *
     * @param postIds IDs to delete
     * @return Result
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * Update post
     *
     * @param post Post info
     * @return Result
     */
    public int updatePost(SysPost post);

    /**
     * Insert post
     *
     * @param post Post info
     * @return Result
     */
    public int insertPost(SysPost post);

    /**
     * Check post name uniqueness
     *
     * @param postName Post name
     * @return Result
     */
    public SysPost checkPostNameUnique(String postName);

    /**
     * Check post code uniqueness
     *
     * @param postCode Post code
     * @return Result
     */
    public SysPost checkPostCodeUnique(String postCode);
}