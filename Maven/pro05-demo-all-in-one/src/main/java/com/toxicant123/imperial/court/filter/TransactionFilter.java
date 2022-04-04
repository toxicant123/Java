package com.toxicant123.imperial.court.filter;

import com.toxicant123.imperial.court.util.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-03 12:48
 */
public class TransactionFilter implements Filter {

    //声明集合保存静态资源扩展名
    private static Set<String> staticResourceExtNameSet;

    {
        staticResourceExtNameSet = new HashSet<>();
        staticResourceExtNameSet.add(".png");
        staticResourceExtNameSet.add(".jpg");
        staticResourceExtNameSet.add(".css");
        staticResourceExtNameSet.add(".js");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 前置操作：排除静态资源
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletPath = request.getServletPath();
        if (servletPath.contains(".")) {
            String extName = servletPath.substring(servletPath.lastIndexOf("."));

            if (staticResourceExtNameSet.contains(extName)) {
                //如果检测到当前请求确实是静态资源，则直接放行，不做事务操作
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }


        Connection connection = null;
        try {
            //1. 获取数据库连接
            connection = JDBCUtils.getConnection();

            //重要操作
            connection.setAutoCommit(false);

            //2. 核心操作
            filterChain.doFilter(servletRequest, servletResponse);

            //3. 提交事务
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            //页面显示：将这里捕获到的异常发送到指定页面显示
            //获取异常信息
            String message = e.getMessage();

            //将异常信息存入请求域
            request.setAttribute("systemMessage",message);

            //将请求转发到指定页面
            request.getRequestDispatcher("/").forward(request,servletResponse);

        } finally {
            JDBCUtils.releaseConnection(connection);
        }
    }

    @Override
    public void destroy() {

    }
}
