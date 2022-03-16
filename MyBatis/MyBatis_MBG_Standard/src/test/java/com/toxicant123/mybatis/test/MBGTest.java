package com.toxicant123.mybatis.test;

import com.toxicant123.mybatis.mapper.EmpMapper;
import com.toxicant123.mybatis.pojo.Emp;
import com.toxicant123.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-16 15:28
 */
public class MBGTest {

    static EmpMapper mapper;

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(EmpMapper.class);
    }

    @Test
    public void testMBG1() {
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(e -> System.out.println(e));

    }

    @Test
    public void testMBG2() {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameIsNotNull();
        List<Emp> emps = mapper.selectByExample(empExample);
        System.out.println(emps);

    }
}
