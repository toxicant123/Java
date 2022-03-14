package com.toxicant123.mybatis.test;


import com.toxicant123.mybatis.mapper.SelectMapper;
import com.toxicant123.mybatis.pojo.User;
import com.toxicant123.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-13 17:46
 */
public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能：
     * 1. 若查询出的数据只有一条
     * a> 可以通过实体类对象接收
     * b> 可以通过list集合接收
     * c> 可以通过map集合接收
     * 2. 若查询出的数据有多条
     * a> 可以通过list集合接收
     * b> 可以通过map类型的list集合接收
     * c> 可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某个字段的值作为键，放在同一个map集合中
     * 注意：一定不能通过实体类对象接收，此时会抛出异常TooManyResultsException
     *
     * MyBatis设置了默认的类型别名
     * java.lang.Integer -> int,integer
     * int -> _int, _integer
     * String -> string
     */

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User userById = mapper.getUserById(4);
        System.out.println(userById);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer result = mapper.getCount();
        System.out.println(result);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = mapper.getUserByIdToMap(4);
        System.out.println(userByIdToMap);
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);
    }
}