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
}
