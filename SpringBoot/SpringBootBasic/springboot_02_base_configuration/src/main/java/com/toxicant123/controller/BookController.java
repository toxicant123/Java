package com.toxicant123.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest模式
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-06-14 8:46
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getById(){
        return "springboot is running";
    }
}
