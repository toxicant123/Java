package com.toxicant123;

import com.toxicant123.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SSMPApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Test
    public void test1() {
        bookDao.selectOne()
    }

}
