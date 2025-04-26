package com.ruoyi.feedback.controller;

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
import com.ruoyi.feedback.domain.GrsFeedback;
import com.ruoyi.feedback.service.IGrsFeedbackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * FeedbackController
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/feedback")
public class GrsFeedbackController extends BaseController {

    @Autowired
    private IGrsFeedbackService grsFeedbackService;

    /**
     * Search feedback list
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(GrsFeedback grsFeedback) {
        startPage();
        List<GrsFeedback> list = grsFeedbackService.selectGrsFeedbackList(grsFeedback);
        return getDataTable(list);
    }

    /**
     * Export feedback list
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:export')")
    @Log(title = "Feedback", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GrsFeedback grsFeedback) {
        List<GrsFeedback> list = grsFeedbackService.selectGrsFeedbackList(grsFeedback);
        ExcelUtil<GrsFeedback> util = new ExcelUtil<GrsFeedback>(GrsFeedback.class);
        util.exportExcel(response, list, "Feedback数据");
    }

    /**
     * Search feedback by ID
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:query')")
    @GetMapping(value = "/{feedbackId}")
    public AjaxResult getInfo(@PathVariable("feedbackId") Long feedbackId) {
        return success(grsFeedbackService.selectGrsFeedbackByFeedbackId(feedbackId));
    }

    /**
     * Add feedback
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:add')")
    @Log(title = "Feedback", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GrsFeedback grsFeedback) {
        return toAjax(grsFeedbackService.insertGrsFeedback(grsFeedback));
    }

    /**
     * Update feedback
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:edit')")
    @Log(title = "Feedback", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GrsFeedback grsFeedback) {
        return toAjax(grsFeedbackService.updateGrsFeedback(grsFeedback));
    }

    /**
     * Delete feedback
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:remove')")
    @Log(title = "Feedback", businessType = BusinessType.DELETE)
	@DeleteMapping("/{feedbackIds}")
    public AjaxResult remove(@PathVariable Long[] feedbackIds) {
        return toAjax(grsFeedbackService.deleteGrsFeedbackByFeedbackIds(feedbackIds));
    }
}
