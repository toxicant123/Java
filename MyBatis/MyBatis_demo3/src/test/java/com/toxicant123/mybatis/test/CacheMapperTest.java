package com.toxicant123.mybatis.test;

import com.mysql.jdbc.CharsetMapping;
import com.toxicant123.mybatis.mapper.CacheMapper;
import com.toxicant123.mybatis.pojo.Emp;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-16 10:37
 */
public class CacheMapperTest {

    @Test
    public void testGetEmpByEid() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(10);
        System.out.println(empByEid);
        Emp empByEid2 = mapper.getEmpByEid(10);
        System.out.println(empByEid2);
    }

    @Test
    public void testGetEmpByEid2() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(10);
        System.out.println(empByEid);
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid2 = mapper1.getEmpByEid(10);
        System.out.println(empByEid2);
    }

    @Test
    public void testGetEmpByEid3() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(10);
        System.out.println(empByEid);
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession2.getMapper(CacheMapper.class);
        Emp empByEid1 = mapper.getEmpByEid(1);
        System.out.println(empByEid);
    }

    @Test
    public void testGetEmpByEid4() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(10);
        System.out.println(empByEid);
        mapper.insertEmp(new Emp(0,"abc",23,"m","123@qq.com",null));
        Emp empByEid2 = mapper.getEmpByEid(10);
        System.out.println(empByEid2);
    }

    @Test
    public void testGetEmpByEid5() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEid = mapper.getEmpByEid(10);
        System.out.println(empByEid);
        sqlSession.clearCache();
        Emp empByEid2 = mapper.getEmpByEid(10);
        System.out.println(empByEid2);
    }

    @Test
    public void testTwoCache() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp empByEid = mapper1.getEmpByEid(1);
            System.out.println(empByEid);
            Emp empByEid1 = mapper2.getEmpByEid(1);
            System.out.println(empByEid1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwoCache2() {
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp empByEid = mapper1.getEmpByEid(1);
            System.out.println(empByEid);
            sqlSession1.commit();
            Emp empByEid1 = mapper2.getEmpByEid(1);
            System.out.println(empByEid1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}