package com.toxicant123;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-06-05 12:46
 */
public class Log4JTest {
    //快速入门
    @Test
    public void testQuick(){
        //初始化配置信息，在入门案例中暂不使用配置文件
        BasicConfigurator.configure();

        //获取日志记录器对象
        Logger logger = Logger.getLogger(Log4JTest.class);
        //日志记录输出
        logger.info("hello log4j");

        logger.fatal("fatal");  //严重错误，一般会造成系统崩溃并停止运行
        logger.error("error");  //错误信息，不会影响系统运行
        logger.warn("warn");    //警告信息，可能会发生问题
        logger.info("info");    //运行信息，数据连接、网络连接、IO操作等等
        logger.debug("debug");  //调试信息，一般在开发中使用，记录程序变量参数传递信息等等
        logger.trace("trace");  //追踪信息，记录程序所有的流程信息
    }

    //快速入门2
    //使用resources/log4j.profperties中的设置
    @Test
    public void testQuick2(){
        //初始化配置信息，在入门案例中暂不使用配置文件
//        BasicConfigurator.configure();

        //获取日志记录器对象
        Logger logger = Logger.getLogger(Log4JTest.class);
        //日志记录输出
        logger.info("hello log4j");

        logger.fatal("fatal");  //严重错误，一般会造成系统崩溃并停止运行
        logger.error("error");  //错误信息，不会影响系统运行
        logger.warn("warn");    //警告信息，可能会发生问题
        logger.info("info");    //运行信息，数据连接、网络连接、IO操作等等
        logger.debug("debug");  //调试信息，一般在开发中使用，记录程序变量参数传递信息等等
        logger.trace("trace");  //追踪信息，记录程序所有的流程信息
    }

    //快速入门3
    //开启log4j内置日志记录
    @Test
    public void testQuick3(){
        //开启log4j内置日志记录
        LogLog.setInternalDebugging(true);

        //获取日志记录器对象
        Logger logger = Logger.getLogger(Log4JTest.class);
        //日志记录输出
        logger.info("hello log4j");

        logger.fatal("fatal");  //严重错误，一般会造成系统崩溃并停止运行
        logger.error("error");  //错误信息，不会影响系统运行
        logger.warn("warn");    //警告信息，可能会发生问题
        logger.info("info");    //运行信息，数据连接、网络连接、IO操作等等
        logger.debug("debug");  //调试信息，一般在开发中使用，记录程序变量参数传递信息等等
        logger.trace("trace");  //追踪信息，记录程序所有的流程信息
    }

    //测试RollingFile
    @Test
    public void testRollingFile(){
        //开启log4j内置日志记录
        LogLog.setInternalDebugging(true);

        //获取日志记录器对象
        Logger logger = Logger.getLogger(Log4JTest.class);
        //日志记录输出
        logger.info("hello log4j");

        for (int i = 0;i < 10000; i++) {
            logger.fatal("fatal");  //严重错误，一般会造成系统崩溃并停止运行
            logger.error("error");  //错误信息，不会影响系统运行
            logger.warn("warn");    //警告信息，可能会发生问题
            logger.info("info");    //运行信息，数据连接、网络连接、IO操作等等
            logger.debug("debug");  //调试信息，一般在开发中使用，记录程序变量参数传递信息等等
            logger.trace("trace");  //追踪信息，记录程序所有的流程信息
        }
    }
}
