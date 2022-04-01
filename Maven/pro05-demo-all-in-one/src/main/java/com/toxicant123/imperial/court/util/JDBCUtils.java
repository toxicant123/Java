package com.toxicant123.imperial.court.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 功能1：从数据源获取数据库连接<br/>
 * 功能2：将数据源绑定到本地线程（借助ThreadLocal）<br/>
 * 功能3：释放线程时和本地线程解除绑定<br/>
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-31 20:50
 */
public class JDBCUtils {

    //数据源成员变量设置为静态资源，保证大对象的单例性，同时保证静态方法中可以访问
    private static DataSource dataSource;

    // 在静态代码块中初始化数据源
    static {
        try {
            //从jdbc.properties文件中读取连接数据库的信息
            //为了保证程序代码的可移植性，需要基于一个确定的基准来读取这个文件
            //确定的基准：类路径的根目录。resources目录下的内容通过构建操作中的打包操作后会确定放在WEB-INF/classes目录下
            //WEB-INF/classes目录存放编译好的*.class字节码文件，所以这个目录我们就称之为类路径
            //类路径无论在本地运行还是在服务器端运行都是一个确定的基准
            //操作具体代码：
            //1. 获取当前类的类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();

            //2. 通过类加载器对象从类路径根目录下读取文件
            InputStream stream = classLoader.getResourceAsStream("jdbc.properties");

            //3. 使用Properties类封装属性文件中的数据
            Properties properties = new Properties();
            properties.load(stream);

            //4. 根据Properties对象（已经封装了数据库连接信息）来创建数据源对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            //为了避免在真正抛出异常后，catch块捕获到异常从而掩盖问题
            //这里将所捕获的异常封装为运行时异常继续抛出
            throw new RuntimeException(e);
        }
    }

    /**
     * 工具方法：获取数据库连接并返回
     * @return
     */
    public static Connection getConnection(){
        return null;
    }

}
