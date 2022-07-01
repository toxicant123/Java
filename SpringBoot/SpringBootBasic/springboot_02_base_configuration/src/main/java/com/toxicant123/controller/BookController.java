package com.toxicant123.controller;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${country}")
    private String country1;

    @Value("${user1.name}")
    private String name1;

    @Value("${likes[1]}")
    private String hobby;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running");
        System.out.println("country1: " + country1);
        System.out.println("name: " + name1);
        System.out.println("hobby: " + hobby);
        return "springboot is running";
    }
}
