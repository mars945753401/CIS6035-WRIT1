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
import com.ruoyi.reservation.domain.GrsEquipReservation;
import com.ruoyi.reservation.service.IGrsEquipReservationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Equipment ReservationController
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/reservation/equip")
public class GrsEquipReservationController extends BaseController {

    @Autowired
    private IGrsEquipReservationService grsEquipReservationService;

    /**
     * Search equipment reservation list
     */
    @PreAuthorize("@ss.hasPermi('reservation:equipReservation:list')")
    @GetMapping("/list")
    public TableDataInfo list(GrsEquipReservation grsEquipReservation) {
        startPage();
        List<GrsEquipReservation> list = grsEquipReservationService.selectGrsEquipReservationList(grsEquipReservation);
        return getDataTable(list);
    }

    /**
     * Export equipment reservation list
     */
    @PreAuthorize("@ss.hasPermi('reservation:equipReservation:export')")
    @Log(title = "Equipment Reservation", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GrsEquipReservation grsEquipReservation) {
        List<GrsEquipReservation> list = grsEquipReservationService.selectGrsEquipReservationList(grsEquipReservation);
        ExcelUtil<GrsEquipReservation> util = new ExcelUtil<GrsEquipReservation>(GrsEquipReservation.class);
        util.exportExcel(response, list, "Equipment Reservation Data");
    }

    /**
     * Search equipment reservation by ID
     */
    @PreAuthorize("@ss.hasPermi('reservation:equipReservation:query')")
    @GetMapping(value = "/{equipReservationId}")
    public AjaxResult getInfo(@PathVariable("equipReservationId") Long equipReservationId) {
        return success(grsEquipReservationService.selectGrsEquipReservationByEquipReservationId(equipReservationId));
    }

    /**
     * Add equipment reservation
     */
    @PreAuthorize("@ss.hasPermi('reservation:equipReservation:add')")
    @Log(title = "Equipment Reservation", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GrsEquipReservation grsEquipReservation) {
        return toAjax(grsEquipReservationService.insertGrsEquipReservation(grsEquipReservation));
    }

    /**
     * Update equipment reservation
     */
    @PreAuthorize("@ss.hasPermi('reservation:equipReservation:edit')")
    @Log(title = "Equipment Reservation", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GrsEquipReservation grsEquipReservation) {
        return toAjax(grsEquipReservationService.updateGrsEquipReservation(grsEquipReservation));
    }

    /**
     * Delete equipment reservation
     */
    @PreAuthorize("@ss.hasPermi('reservation:equipReservation:remove')")
    @Log(title = "Equipment Reservation", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipReservationIds}")
    public AjaxResult remove(@PathVariable Long[] equipReservationIds) {
        return toAjax(grsEquipReservationService.deleteGrsEquipReservationByEquipReservationIds(equipReservationIds));
    }
}
