package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-16 10:20
 */
public interface CacheMapper {

    /**
     * 根据eid查询出员工
     * @param eid
     * @return
     */
    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(@Param("emp") Emp emp);
}
