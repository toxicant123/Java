package com.toxicant123.mybatis.test;


import com.toxicant123.mybatis.mapper.ParameterMapper;
import com.toxicant123.mybatis.pojo.User;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-13 10:43
 */
public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的两种方式：${}和#{}
     * ${}本质是字符串拼接，要注意单引号问题
     * #{}本质是占位符赋值
     * MyBatis获取参数值的各种情况：
     * 1. mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意字符串获取参数值，但是需要注意${}的单引号问题
     * 2. mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a> 以arg0,arg1...为键，以参数为值
     * b> 以param1,param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     */

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(e -> System.out.println(e));
    }

    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void testChecLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","123");
        System.out.println(user);
    }
}