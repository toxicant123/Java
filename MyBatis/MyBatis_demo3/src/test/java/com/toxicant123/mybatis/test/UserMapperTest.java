package com.toxicant123.mybatis.test;

import com.toxicant123.mybatis.mapper.UserMapper;
import com.toxicant123.mybatis.pojo.User;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 9:18
 */
public class UserMapperTest {

    @Test
    public void selectUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(10);
        System.out.println(user);
    }
}