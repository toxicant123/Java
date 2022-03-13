package com.toxicant123.mybatis.mapper;


import com.toxicant123.mybatis.pojo.User;

import java.util.List;

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
}
