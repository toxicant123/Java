package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 9:49
 */
public interface EmpMapper {

    /**
     * 获取所有员工的信息
     * @return
     */
    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     * @param eid
     * @return
     */
    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工对应的部门信息
     * 分步查询第一步：查询员工信息
     * @param eid
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);
}
