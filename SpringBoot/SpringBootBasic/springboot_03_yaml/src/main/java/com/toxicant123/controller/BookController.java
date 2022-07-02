package com.toxicant123.controller;

import com.toxicant123.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Value("${user2.location}")
    private String user2Location;

    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running");
        System.out.println("country1: " + country1);
        System.out.println("name: " + name1);
        System.out.println("hobby: " + hobby);
        System.out.println("user2Location: " + user2Location);
        System.out.println(env.getProperty("country"));
        System.out.println(myDataSource);

        return "springboot is running";
    }
}
