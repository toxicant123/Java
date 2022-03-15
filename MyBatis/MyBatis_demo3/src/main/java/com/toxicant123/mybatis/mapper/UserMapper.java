package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-15 9:11
 */
public interface UserMapper {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User selectUserById(@Param("id") int id);
}
