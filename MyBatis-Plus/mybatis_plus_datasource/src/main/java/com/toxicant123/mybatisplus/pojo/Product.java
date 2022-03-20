package com.toxicant123.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-20 11:10
 */
@Data
public class Product {
    private Integer id;

    private String name;

    private Integer price;
    @Version
    private Integer version;
}
