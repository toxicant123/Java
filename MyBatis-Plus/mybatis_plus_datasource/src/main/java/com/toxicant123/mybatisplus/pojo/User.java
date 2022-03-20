package com.toxicant123.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-20 10:53
 */
@Data
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private Integer sex;

    private Integer isDeleted;
}
