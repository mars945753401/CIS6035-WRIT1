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
import com.ruoyi.resource.domain.GrsEquip;
import com.ruoyi.resource.service.IGrsEquipService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * EquipmentController
 * 
 * @author Tianyang Pan
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/resource/equip")
public class GrsEquipController extends BaseController {

    @Autowired
    private IGrsEquipService grsEquipService;

    /**
     * Search equipment list
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:list')")
    @GetMapping("/list")
    public TableDataInfo list(GrsEquip grsEquip) {
        startPage();
        List<GrsEquip> list = grsEquipService.selectGrsEquipList(grsEquip);
        return getDataTable(list);
    }

    /**
     * Search equipment list (without pagination)
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:list')")
    @GetMapping("/listEquipWithoutPagination")
    public AjaxResult listEquipWithoutPagination(GrsEquip grsEquip) {
        List<GrsEquip> list = grsEquipService.selectGrsEquipList(grsEquip);
        return success(list);
    }

    /**
     * Export equipment list
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:export')")
    @Log(title = "Equipment", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GrsEquip grsEquip) {
        List<GrsEquip> list = grsEquipService.selectGrsEquipList(grsEquip);
        ExcelUtil<GrsEquip> util = new ExcelUtil<GrsEquip>(GrsEquip.class);
        util.exportExcel(response, list, "Equipment数据");
    }

    /**
     * Search equipment by ID
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:query')")
    @GetMapping(value = "/{equipId}")
    public AjaxResult getInfo(@PathVariable("equipId") Long equipId) {
        return success(grsEquipService.selectGrsEquipByEquipId(equipId));
    }

    /**
     * Add equipment
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:add')")
    @Log(title = "Equipment", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GrsEquip grsEquip) {
        return toAjax(grsEquipService.insertGrsEquip(grsEquip));
    }

    /**
     * Update equipment
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:edit')")
    @Log(title = "Equipment", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GrsEquip grsEquip) {
        return toAjax(grsEquipService.updateGrsEquip(grsEquip));
    }

    /**
     * Delete equipment
     */
    @PreAuthorize("@ss.hasPermi('resource:equip:remove')")
    @Log(title = "Equipment", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipIds}")
    public AjaxResult remove(@PathVariable Long[] equipIds) {
        return toAjax(grsEquipService.deleteGrsEquipByEquipIds(equipIds));
    }
}
