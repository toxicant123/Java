package com.toxicant123.mybatisx.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toxicant123.mybatisx.pojo.User;

/**
* @author 13655
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-03-20 12:20:22
* @Entity com.toxicant123.mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);
}




