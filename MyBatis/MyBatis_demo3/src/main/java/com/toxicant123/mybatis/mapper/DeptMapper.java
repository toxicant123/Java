package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 9:49
 */
public interface DeptMapper {

    /**
     * 通过分步查询查询员工以及员工对应的部门信息
     * 分步查询第二步：通过did查询员工所对应的部门
     * @param did
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 获取部门以及部门中所有的员工信息
     * @param did
     * @return
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询查询部门以及部门中所有员工的信息
     * 分步查询第一步：查询部门信息
     * @param did
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
