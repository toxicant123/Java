package com.toxicant123;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-06-05 19:47
 */
public class JCLTest {
    @Test
    public void testQuick() throws Exception{
        //获取log日志记录器对象
        Log log = LogFactory.getLog(JCLTest.class);
        //日志记录输出
        log.info("hello jcl");
    }
}
