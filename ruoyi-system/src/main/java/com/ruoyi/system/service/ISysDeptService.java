package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * Dept interface
 * 
 * @author Tianyang Pan
 */
public interface ISysDeptService
{
    /**
     * Select dept list
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * Select dept tree
     */
    public List<TreeSelect> selectDeptTreeList(SysDept dept);

    /**
     * Build dept tree for front end
     */
    public List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * Build dept tree for front end
     */
    public List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * Select dept list by role ID
     */
    public List<Long> selectDeptListByRoleId(Long roleId);

    /**
     * Select dept by dept ID
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * Select sub depts by dept ID
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * Check whether given dept has sub depts
     */
    public boolean hasChildByDeptId(Long deptId);

    /**
     * Check whether dept has users
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * Check whether dept name is unique
     */
    public boolean checkDeptNameUnique(SysDept dept);

    /**
     * Check whether dept has data scope
     */
    public void checkDeptDataScope(Long deptId);

    /**
     * Add dept
     */
    public int insertDept(SysDept dept);

    /**
     * Update dept
     */
    public int updateDept(SysDept dept);

    /**
     * Delete dept by dept ID
     */
    public int deleteDeptById(Long deptId);
}
