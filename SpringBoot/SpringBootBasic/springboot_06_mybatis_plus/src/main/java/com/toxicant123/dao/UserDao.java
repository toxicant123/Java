package com.toxicant123.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toxicant123.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-07 21:54
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
