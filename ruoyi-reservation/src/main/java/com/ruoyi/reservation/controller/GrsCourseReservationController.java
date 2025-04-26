package com.ruoyi.reservation.controller;

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
import com.ruoyi.reservation.domain.GrsCourseReservation;
import com.ruoyi.reservation.service.IGrsCourseReservationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Course ReservationController
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/reservation/course")
public class GrsCourseReservationController extends BaseController {

    @Autowired
    private IGrsCourseReservationService grsCourseReservationService;

    /**
     * Search course reservation list
     */
    @PreAuthorize("@ss.hasPermi('reservation:courseReservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(GrsCourseReservation grsCourseReservation) {
        startPage();
        List<GrsCourseReservation> list = grsCourseReservationService.selectGrsCourseReservationList(grsCourseReservation);
        return getDataTable(list);
    }

    /**
     * Export course reservation list
     */
    @PreAuthorize("@ss.hasPermi('reservation:courseReservation:export')")
    @Log(title = "Course Reservation", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GrsCourseReservation grsCourseReservation) {
        List<GrsCourseReservation> list = grsCourseReservationService.selectGrsCourseReservationList(grsCourseReservation);
        ExcelUtil<GrsCourseReservation> util = new ExcelUtil<GrsCourseReservation>(GrsCourseReservation.class);
        util.exportExcel(response, list, "Course Reservation数据");
    }

    /**
     * Search course reservation by ID
     */
    @PreAuthorize("@ss.hasPermi('reservation:courseReservation:query')")
    @GetMapping(value = "/{courseReservationId}")
    public AjaxResult getInfo(@PathVariable("courseReservationId") Long courseReservationId) {
        return success(grsCourseReservationService.selectGrsCourseReservationByCourseReservationId(courseReservationId));
    }

    /**
     * Add course reservation
     */
    @PreAuthorize("@ss.hasPermi('reservation:courseReservation:add')")
    @Log(title = "Course Reservation", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GrsCourseReservation grsCourseReservation) {
        return toAjax(grsCourseReservationService.insertGrsCourseReservation(grsCourseReservation));
    }

    /**
     * Update course reservation
     */
    @PreAuthorize("@ss.hasPermi('reservation:courseReservation:edit')")
    @Log(title = "Course Reservation", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GrsCourseReservation grsCourseReservation) {
        return toAjax(grsCourseReservationService.updateGrsCourseReservation(grsCourseReservation));
    }

    /**
     * Delete course reservation by ID
     */
    @PreAuthorize("@ss.hasPermi('reservation:courseReservation:remove')")
    @Log(title = "Course Reservation", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseReservationIds}")
    public AjaxResult remove(@PathVariable Long[] courseReservationIds) {
        return toAjax(grsCourseReservationService.deleteGrsCourseReservationByCourseReservationIds(courseReservationIds));
    }
}
