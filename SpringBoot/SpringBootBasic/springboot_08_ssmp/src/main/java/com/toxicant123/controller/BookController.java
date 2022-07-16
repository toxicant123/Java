package com.toxicant123.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.pojo.Book;
import com.toxicant123.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-16 10:24
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.modify(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage, pageSize);
    }
}
