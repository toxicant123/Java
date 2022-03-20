package com.toxicant123.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-20 9:08
 */
@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue
    private Integer sex;
    private String sexname;

    SexEnum(Integer sex, String sexname) {
        this.sex = sex;
        this.sexname = sexname;
    }
}
