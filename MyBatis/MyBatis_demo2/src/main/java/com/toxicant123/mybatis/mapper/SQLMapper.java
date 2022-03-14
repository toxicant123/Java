package com.toxicant123.mybatis.mapper;

import com.toxicant123.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-14 17:08
 */
public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     * @param username
     * @return
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteMore(@Param("ids")String ids);

    /**
     * 查询指定表中的数据
     * @param tableName
     * @return
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    void insertUser(User user);
}
