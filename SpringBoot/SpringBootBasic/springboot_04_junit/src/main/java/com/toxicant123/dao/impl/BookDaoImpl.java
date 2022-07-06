package com.toxicant123.dao.impl;

import com.toxicant123.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-06 8:46
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Override
    public void save() {
        System.out.println("bookdao is running...");
    }
}
