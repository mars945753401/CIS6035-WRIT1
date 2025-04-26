package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPost;

/**
 * Post Information Service Layer
 *
 * @author Tianyang Pan
 */
public interface ISysPostService
{
    /**
     * Query post list
     *
     * @param post Post information
     * @return Post list
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
     * @return Post information
     */
    public SysPost selectPostById(Long postId);

    /**
     * Query user's post selection
     *
     * @param userId User ID
     * @return Selected post IDs
     */
    public List<Long> selectPostListByUserId(Long userId);

    /**
     * Check post name uniqueness
     *
     * @param post Post information
     * @return true=unique, false=not unique
     */
    public boolean checkPostNameUnique(SysPost post);

    /**
     * Check post code uniqueness
     *
     * @param post Post information
     * @return true=unique, false=not unique
     */
    public boolean checkPostCodeUnique(SysPost post);

    /**
     * Count users assigned to a post
     *
     * @param postId Post ID
     * @return User count
     */
    public int countUserPostById(Long postId);

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
     * @param postIds Post IDs to delete
     * @return Result
     */
    public int deletePostByIds(Long[] postIds);

    /**
     * Insert post
     *
     * @param post Post information
     * @return Result
     */
    public int insertPost(SysPost post);

    /**
     * Update post
     *
     * @param post Post information
     * @return Result
     */
    public int updatePost(SysPost post);
}