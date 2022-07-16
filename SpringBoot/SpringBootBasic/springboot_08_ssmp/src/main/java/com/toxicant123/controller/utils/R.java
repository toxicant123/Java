package com.toxicant123.controller.utils;

import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-16 11:49
 */
@Data
public class R {
    private boolean flag;

    private Object data;

    public R() {
    }

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
