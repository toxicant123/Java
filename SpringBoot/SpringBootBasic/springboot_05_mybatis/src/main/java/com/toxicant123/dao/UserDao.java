package com.toxicant123.dao;

import com.toxicant123.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-07 21:54
 */
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    User getById(Integer id);
}
