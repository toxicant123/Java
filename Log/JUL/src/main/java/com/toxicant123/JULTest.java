package com.toxicant123;

import org.junit.Test;

import java.util.logging.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-06-04 19:42
 */
public class JULTest {
    //快速入门
    @Test
    public void testQuick() throws Exception{
        //1. 获取日志记录器对象
        Logger logger = Logger.getLogger("com.toxicant123.JULTest");
        //2. 日志记录输出
        logger.info("hello jul");

        //通用方法进行日志记录
        logger.log(Level.INFO,"info msg");

        //通过占位符的方式输出变量值
        String name = "itcast";
        Integer age = 13;
        logger.log(Level.INFO,"用户信息：{0},{1}", new Object[]{name,age});
    }

    //日志级别
    @Test
    public void testLogLevel() throws Exception{
        //1. 获取日志记录器对象
        Logger logger = Logger.getLogger("com.toxicant123.JULTest");
        //2. 日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // JUL默认的日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    //自定义日志级别
    @Test
    public void testLogConfig() throws Exception{
        //1. 获取日志记录器对象
        Logger logger = Logger.getLogger("com.toxicant123.JULTest");

        //关闭系统默认配置
        logger.setUseParentHandlers(false);

        //自定义配置日志级别

        //创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        //配置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 创建FileHandler 文件输出
        FileHandler fileHandler = new FileHandler("D:\\log\\1.log");
        fileHandler.setFormatter(simpleFormatter);

        //进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        //2. 日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // JUL默认的日志级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    @Test
    public void testLogParent() throws Exception{
        Logger logger1 = Logger.getLogger("com.toxicant123");
        Logger logger2 = Logger.getLogger("com");

        //测试
        Logger parent1 = logger1.getParent();
        if (parent1 == logger2){
            System.out.println("same");
        }

        //LogManager$RootLogger是所有日志记录器的顶级父元素
        System.out.println("logger2 parent:" +logger2.getParent() + ", name:" + logger2.getParent().getName());

        //关闭默认配置
        logger2.setUseParentHandlers(false);

        //设置logger2日志级别
        //创建ConsoleHandler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);

        //配置日志具体级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        
        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info"); // JUL默认的日志级别
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }

    //加载自定义配置文件
    @Test
    public void testLogProperties() throws Exception{
        //读取配置文件，通过类加载器实现

        //创建LogManager

        //通过LogManager加载配置文件
    }
}
