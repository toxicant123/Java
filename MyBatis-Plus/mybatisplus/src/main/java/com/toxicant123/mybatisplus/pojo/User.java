package com.toxicant123.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.toxicant123.mybatisplus.enums.SexEnum;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-17 10:45
 */
@Data
//设置实体类所对应的表名
@TableName("user")
public class User {
    /**
     * 将属性所对应的字段指定为主键
     *  @TableId 注解的value属性用于指定主键的字段
     *  @TableId 注解的type属性设置主键生成策略
     *  @TableId(value = "uid", type = IdType.AUTO)
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    //指定属性所对应的字段名
    @TableField("name")
    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer is_deleted;
}
