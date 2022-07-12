package com.toxicant123;

import com.toxicant123.dao.BookDao;
import com.toxicant123.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SSMPApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    public void testGetById() {
        Book book = bookDao.selectById(1);
        System.out.println(book);
    }
    
    @Test
    public void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

}
