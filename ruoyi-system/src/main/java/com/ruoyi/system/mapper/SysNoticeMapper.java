package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysNotice;

/**
 * Notification announcement data layer
 *
 * @author Tianyang Pan
 */
public interface SysNoticeMapper
{
    /**
     * Query notice by ID
     *
     * @param noticeId Notice ID
     * @return Notice info
     */
    public SysNotice selectNoticeById(Long noticeId);

    /**
     * Query notice list
     *
     * @param notice Notice info
     * @return Notice collection
     */
    public List<SysNotice> selectNoticeList(SysNotice notice);

    /**
     * Insert notice
     *
     * @param notice Notice info
     * @return Result
     */
    public int insertNotice(SysNotice notice);

    /**
     * Update notice
     *
     * @param notice Notice info
     * @return Result
     */
    public int updateNotice(SysNotice notice);

    /**
     * Delete notice by ID
     *
     * @param noticeId Notice ID
     * @return Result
     */
    public int deleteNoticeById(Long noticeId);

    /**
     * Batch delete notices
     *
     * @param noticeIds IDs to delete
     * @return Result
     */
    public int deleteNoticeByIds(Long[] noticeIds);
}