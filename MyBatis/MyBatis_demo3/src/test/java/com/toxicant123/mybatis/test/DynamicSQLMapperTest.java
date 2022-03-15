package com.toxicant123.mybatis.test;

import com.toxicant123.mybatis.mapper.DynamicSQLMapper;
import com.toxicant123.mybatis.pojo.Emp;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
     */

    @Test
    public void getEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empByCondition = mapper.getEmpByCondition(new Emp(null, "张三", 23, "男", "123@qq.com", null));
        System.out.println(empByCondition);
    }
}