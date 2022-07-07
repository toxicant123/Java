package com.toxicant123;

import com.toxicant123.dao.UserDao;
import com.toxicant123.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User byId = userDao.getById(1);
        System.out.println(byId);
    }

}
