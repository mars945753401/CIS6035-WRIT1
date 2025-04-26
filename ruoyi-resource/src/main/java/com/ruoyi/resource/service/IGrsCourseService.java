package com.ruoyi.resource.service;

import java.util.List;
import com.ruoyi.resource.domain.GrsCourse;

/**
 * CourseService interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface IGrsCourseService {

    /**
     * Search course by ID
     */
    public GrsCourse selectGrsCourseByCourseId(Long courseId);

    /**
     * Search course list
     */
    public List<GrsCourse> selectGrsCourseList(GrsCourse grsCourse);

    /**
     * Add course
     */
    public int insertGrsCourse(GrsCourse grsCourse);

    /**
     * Update course
     */
    public int updateGrsCourse(GrsCourse grsCourse);

    /**
     * Batch delete course by IDs
     */
    public int deleteGrsCourseByCourseIds(Long[] courseIds);

    /**
     * Delete course by ID
     */
    public int deleteGrsCourseByCourseId(Long courseId);
}
