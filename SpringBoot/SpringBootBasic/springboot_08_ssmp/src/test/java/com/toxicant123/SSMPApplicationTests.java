package com.toxicant123;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toxicant123.dao.BookDao;
import com.toxicant123.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    
    @Test
    public void testUpdate(){
        QueryWrapper<Book> wrap = new QueryWrapper<>();
        wrap.select("id").orderByDesc("id");
        List<Book> books = bookDao.selectList(wrap);
        Book book = new Book();
        book.setId(books.get(0).getId());
        book.setName("水浒传");
        book.setType("古代小说");
        book.setDescription("108的传奇");
    }

    @Test
    public void testDelete(){
        QueryWrapper<Book> wrap = new QueryWrapper<>();
        wrap.select("id").orderByDesc("id");
        List<Book> books = bookDao.selectList(wrap);
        bookDao.deleteById(books.get(0).getId());
    }
    
    @Test
    public void testGetAll(){
        List<Book> books = bookDao.selectList(null);
        System.out.println(books);
    }
    
    @Test
    public void testGetPage(){
        Page<Book> page = new Page<>(1, 5);
        bookDao.selectPage(page,null);
    }
}
