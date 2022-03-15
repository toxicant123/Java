package com.toxicant123.mybatis.test;

import com.toxicant123.mybatis.mapper.DeptMapper;
import com.toxicant123.mybatis.mapper.EmpMapper;
import com.toxicant123.mybatis.pojo.Dept;
import com.toxicant123.mybatis.pojo.Emp;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 9:54
 */
public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况：
     * a> 在sql语句中为字段起别名，保持和属性名的一致
     * b> 设置全局配置，将下划线自动映射为驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c> 通过resultMap设置自定义的映射关系
     * <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"/>
     *         <result property="empName" column="emp_name"/>
     *         <result property="age" column="age"/>
     *         <result property="sex" column="sex"/>
     *         <result property="email" column="email"/>
     *  </resultMap>
     *
     *  处理多对一的映射关系：
     *  a> 级联属性赋值
     *  b> association
     *  c> 分步查询
     *
     *  处理一对多的映射关系：
     *  a> collection
     *  b> 分步查询
     */

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        System.out.println(allEmp);

    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);

    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDeptByStepOne = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(empAndDeptByStepOne);

    }

    /**
     * 测试延迟加载
     */
    @Test
    public void testGetEmpAndDeptByStep2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDeptByStepOne = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(empAndDeptByStepOne.getEmpName());

    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);

    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmp);

    }
}
