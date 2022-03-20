package com.toxicant123.mybatisplus;

import com.toxicant123.mybatisplus.enums.SexEnum;
import com.toxicant123.mybatisplus.mapper.UserMapper;
import com.toxicant123.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-20 9:12
 */
@SpringBootTest
public class MyBatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1(){
        User user = new User();
        user.setName("admin");
        user.setAge(26);
        user.setEmail("admin@163.com");
        user.setSex(SexEnum.MALE);
        int result = userMapper.insert(user);
        System.out.println("result" + result);
    }
}
