package com.toxicant123;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-06-06 8:17
 */
public class SLF4JTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(SLF4JTest.class);

    @Test
    public void testQuick() throws Exception{
        //日志的输出
        LOGGER.error("error");
        LOGGER.warn("warning");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        //使用占位符输出日志信息
        String name = "Apple";
        Integer age = 14;
        LOGGER.info("用户：{},{}",name,age);

        //将系统的异常信息输出
        try {
            int i = 1 / 0;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            LOGGER.error("wrong:",e);
        }
    }
}
