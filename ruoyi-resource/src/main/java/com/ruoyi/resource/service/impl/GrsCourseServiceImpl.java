package com.ruoyi.resource.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resource.mapper.GrsCourseMapper;
import com.ruoyi.resource.domain.GrsCourse;
import com.ruoyi.resource.service.IGrsCourseService;

/**
 * CourseService implementation
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@Service
public class GrsCourseServiceImpl implements IGrsCourseService {

    @Autowired
    private GrsCourseMapper grsCourseMapper;

    /**
     * Search course by ID
     */
    @Override
    public GrsCourse selectGrsCourseByCourseId(Long courseId) {
        return grsCourseMapper.selectGrsCourseByCourseId(courseId);
    }

    /**
     * Search course list
     */
    @Override
    public List<GrsCourse> selectGrsCourseList(GrsCourse grsCourse) {
        return grsCourseMapper.selectGrsCourseList(grsCourse);
    }

    /**
     * Add course
     */
    @Override
    public int insertGrsCourse(GrsCourse grsCourse) {
        grsCourse.setCreateTime(DateUtils.getNowDate());
        return grsCourseMapper.insertGrsCourse(grsCourse);
    }

    /**
     * Update course
     */
    @Override
    public int updateGrsCourse(GrsCourse grsCourse) {
        grsCourse.setUpdateTime(DateUtils.getNowDate());
        return grsCourseMapper.updateGrsCourse(grsCourse);
    }

    /**
     * Batch delete course by IDs
     */
    @Override
    public int deleteGrsCourseByCourseIds(Long[] courseIds) {
        return grsCourseMapper.deleteGrsCourseByCourseIds(courseIds);
    }

    /**
     * Delete course by ID
     */
    @Override
    public int deleteGrsCourseByCourseId(Long courseId) {
        return grsCourseMapper.deleteGrsCourseByCourseId(courseId);
    }
}
