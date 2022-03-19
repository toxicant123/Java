package com.toxicant123.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toxicant123.mybatisplus.mapper.UserMapper;
import com.toxicant123.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-19 10:08
 */
@SpringBootTest
public class MyBatisPlusPluginTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testPageVo(){
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPageVo(page, 20);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
