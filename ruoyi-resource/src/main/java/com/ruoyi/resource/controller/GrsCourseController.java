package com.ruoyi.resource.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.resource.domain.GrsCourse;
import com.ruoyi.resource.service.IGrsCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * CourseController
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/resource/course")
public class GrsCourseController extends BaseController {

    @Autowired
    private IGrsCourseService grsCourseService;

    /**
     * Search course list
     */
    @PreAuthorize("@ss.hasPermi('resource:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(GrsCourse grsCourse) {
        startPage();
        List<GrsCourse> list = grsCourseService.selectGrsCourseList(grsCourse);
        return getDataTable(list);
    }

    /**
     * Search course list (without pagination)
     */
    @PreAuthorize("@ss.hasPermi('resource:course:list')")
    @GetMapping("/listCourseWithoutPagination")
    public AjaxResult listCourseWithoutPagination(GrsCourse grsCourse) {
        List<GrsCourse> list = grsCourseService.selectGrsCourseList(grsCourse);
        return success(list);
    }

    /**
     * Export course list
     */
    @PreAuthorize("@ss.hasPermi('resource:course:export')")
    @Log(title = "Course", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GrsCourse grsCourse) {
        List<GrsCourse> list = grsCourseService.selectGrsCourseList(grsCourse);
        ExcelUtil<GrsCourse> util = new ExcelUtil<GrsCourse>(GrsCourse.class);
        util.exportExcel(response, list, "Course数据");
    }

    /**
     * Search course by ID
     */
    @PreAuthorize("@ss.hasPermi('resource:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId) {
        return success(grsCourseService.selectGrsCourseByCourseId(courseId));
    }

    /**
     * Add course
     */
    @PreAuthorize("@ss.hasPermi('resource:course:add')")
    @Log(title = "Course", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GrsCourse grsCourse) {
        return toAjax(grsCourseService.insertGrsCourse(grsCourse));
    }

    /**
     * Update course
     */
    @PreAuthorize("@ss.hasPermi('resource:course:edit')")
    @Log(title = "Course", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GrsCourse grsCourse) {
        return toAjax(grsCourseService.updateGrsCourse(grsCourse));
    }

    /**
     * Delete course
     */
    @PreAuthorize("@ss.hasPermi('resource:course:remove')")
    @Log(title = "Course", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds) {
        return toAjax(grsCourseService.deleteGrsCourseByCourseIds(courseIds));
    }
}
