package com.toxicant123;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-06-10 21:10
 */
public class LogbackTest {
    private Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    //快速入门
    @Test
    public void testQuick() throws Exception {
        //日志输出
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); //默认级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
