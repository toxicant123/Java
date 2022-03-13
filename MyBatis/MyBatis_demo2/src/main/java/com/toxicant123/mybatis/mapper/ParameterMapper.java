package com.toxicant123.mybatis.mapper;


import com.toxicant123.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-13 10:35
 */
public interface ParameterMapper {
    /**
     * 查询所有员工信息
     * @return
     */
    List<User> getAllUser();

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 验证登录
     * @param name
     * @param password
     * @return
     */
    User checkLogin(String name, String password);

    /**
     * 验证登录（参数为map）
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 验证登录（使用@Param）
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(@Param("username")String username, @Param("password")String password);
}
