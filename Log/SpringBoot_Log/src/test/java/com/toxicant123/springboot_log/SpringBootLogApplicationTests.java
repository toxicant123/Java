package com.toxicant123.springboot_log;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootLogApplicationTests {
    //声明日志记录器对象
    public static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLogApplicationTests.class);

    @Test
    public void testQuick(){
        //打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); //默认日志级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        // 使用log4j2使用桥接器切换为slf4j门面和logback实现
        org.apache.logging.log4j.Logger logger  = LogManager.getLogger(SpringBootLogApplicationTests.class);
        logger.info("log4j2 info");
    }

}
