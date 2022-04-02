package com.toxicant123.maven;

import com.toxicant123.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-02 23:16
 */
public class ImperialCourtTest {

    @Test
    public void testGetConnection(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);
    }
}
