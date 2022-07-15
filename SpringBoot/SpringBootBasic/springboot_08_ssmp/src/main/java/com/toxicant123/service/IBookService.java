package com.toxicant123.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.toxicant123.pojo.Book;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-15 20:12
 */
public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);
}
