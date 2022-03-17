package com.toxicant123.mybatisplus.pojo;

import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-17 10:45
 */
@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}