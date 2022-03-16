package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

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
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose，when，otherwise
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     * @param eids
     * @return
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     * @param emps
     * @return
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);
}
