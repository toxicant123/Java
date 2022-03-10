package com.toxicant123.mybatis.test;

import com.toxicant123.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-10 23:02
 */
public class MyBatisTest {
    /**
     * <p>
     *     sqlSession默认不自动提交事务，若需要自动提交事务<br>
     *     可以使用sqlSessionFactory.openSession(true)
     * </p>
     * @throws Exception
     */
    @Test
    public void testMyBatis() throws Exception {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession（若构造器参数为true则可以自动提交事务）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = mapper.insertUser();
        //提交事务
//        sqlSession.commit();
        System.out.println("result: " + result);
    }
}
