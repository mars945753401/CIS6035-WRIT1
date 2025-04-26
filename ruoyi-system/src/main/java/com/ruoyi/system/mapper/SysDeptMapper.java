package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * Dept mapper
 * 
 * @author Tianyang Pan
 */
public interface SysDeptMapper
{
    /**
     * Select dept list
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * Select dept tree by role ID
     */
    public List<Long> selectDeptListByRoleId(@Param("roleId") Long roleId, @Param("deptCheckStrictly") boolean deptCheckStrictly);

    /**
     * Select dept by ID
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * Select sub depts by ID
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);

    /**
     * Select normal sub depts by ID
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * Is dept has sub depts by ID
     */
    public int hasChildByDeptId(Long deptId);

    /**
     * Check whether dept has users
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * Check whether dept name is unique
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * Add dept
     */
    public int insertDept(SysDept dept);

    /**
     * Update dept
     */
    public int updateDept(SysDept dept);

    /**
     * Update dept status
     */
    public void updateDeptStatusNormal(Long[] deptIds);

    /**
     * Update subdepts
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

    /**
     * Delete dept by ID
     */
    public int deleteDeptById(Long deptId);
}
