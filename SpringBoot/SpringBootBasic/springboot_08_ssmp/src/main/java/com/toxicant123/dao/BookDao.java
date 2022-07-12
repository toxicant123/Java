package com.toxicant123.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toxicant123.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-12 23:08
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
