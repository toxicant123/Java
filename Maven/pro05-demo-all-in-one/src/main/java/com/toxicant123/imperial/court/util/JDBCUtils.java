package com.toxicant123.imperial.court.util;

import javax.sql.DataSource;

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

    //数据源
    private static DataSource dataSource;

}
