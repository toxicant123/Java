package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 15:45
 */
public interface DynamicSQLMapper {

    /**
     * 多条件查询
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);
}
