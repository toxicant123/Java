package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.Emp;

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
}
