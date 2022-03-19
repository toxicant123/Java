package com.toxicant123.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toxicant123.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-17 10:53
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(@Param("id") Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page MyBatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

}
