package com.toxicant123.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-19 11:10
 */
@Data
@TableName("t_product")
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
