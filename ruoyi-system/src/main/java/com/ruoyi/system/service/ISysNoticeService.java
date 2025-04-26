package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysNotice;

/**
 * Announcement Service Layer
 *
 * @author Tianyang Pan
 */
public interface ISysNoticeService
{
    /**
     * Query announcement by ID
     *
     * @param noticeId Announcement ID
     * @return Announcement information
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * Query announcement list
     *
     * @param notice Announcement information
     * @return Announcement collection
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * Insert announcement
     *
     * @param notice Announcement information
     * @return Result
     */
    public int insertNotice(SysNotice notice);

    /**
     * Update announcement
     *
     * @param notice Announcement information
     * @return Result
     */
    public int updateNotice(SysNotice notice);

    /**
     * Delete announcement by ID
     *
     * @param noticeId Announcement ID
     * @return Result
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * Batch delete announcements
     *
     * @param noticeIds Announcement IDs to delete
     * @return Result
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}