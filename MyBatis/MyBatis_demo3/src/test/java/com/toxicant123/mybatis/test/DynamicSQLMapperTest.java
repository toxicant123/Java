package com.toxicant123.mybatis.test;

import com.toxicant123.mybatis.mapper.DynamicSQLMapper;
import com.toxicant123.mybatis.pojo.Emp;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 16:00
 */
public class DynamicSQLMapperTest {

    /**
     * 动态SQL：
     * 1. if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2. where：
     * 但where标签中有内容时，会自动生成where关键字，并且将内容前多余的and或or去掉
     * 但where标签中没有内容时，此时where标签没有任何效果
     * 注意：where标签不能将其中内容后多余的and或or去掉
     * 3. trim：
     * 若标签中有内容时：
     * prefix|suffix：将trim标签中内容前面或后面添加指定内容
     * suffixOverrides|prefixOverrides：将trim标签中内容前面或后面去掉指定内容
     * 若标签中没有内容时：trim标签也没有任何效果
     * 4. choose，when，otherwise，相当于if...else if...else
     * when至少要有一个，otherwise最多只能有一个
     * 5. foreach
     * collection：设置需要循环的数组或组合
     * item：表示数组或集合中的每一个数据
     * separator：循环体之间的分隔符
     * open：foreach标签所循环的所有内容的开始符
     * close：foreach标签所循环的所有内容的结束符
     * 6. sql片段
     * 设置sql片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     * 引用sql片段：<include refid="empColumns"/>
     */

    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, "张三", 23, "男", "123@qq.com", null));
        System.out.println(empByCondition);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByChoose = mapper.getEmpByChoose(new Emp(null, "张三", 23, "男", "123@qq.com", null));
        System.out.println(empByChoose);
    }

    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{7, 8, 9});
        System.out.println(i);
    }

    @Test
    public void testInsertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp(0,"Jhon",24,"m","tian@qq.com",null));
        emps.add(new Emp(0,"Lucy",18,"w","drink@qwe.com",null));
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);
    }
}