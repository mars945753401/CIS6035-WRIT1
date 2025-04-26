package com.ruoyi.resource.mapper;

import java.util.List;
import com.ruoyi.resource.domain.GrsCourse;

/**
 * CourseMapper interface
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
public interface GrsCourseMapper {

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
     * Delete course by ID
     */
    public int deleteGrsCourseByCourseId(Long courseId);

    /**
     * Batch delete course by IDs
     */
    public int deleteGrsCourseByCourseIds(Long[] courseIds);
}
