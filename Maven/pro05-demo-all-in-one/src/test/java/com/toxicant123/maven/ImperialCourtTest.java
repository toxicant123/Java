package com.toxicant123.maven;

import com.toxicant123.imperial.court.dao.BaseDao;
import com.toxicant123.imperial.court.entity.Emp;
import com.toxicant123.imperial.court.entity.Memorials;
import com.toxicant123.imperial.court.service.impl.MemorialsServiceImpl;
import com.toxicant123.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-04-02 23:16
 */
public class ImperialCourtTest {

    private BaseDao<Emp> baseDao = new BaseDao<>();
    
    @Test
    public void testGetSingleBean(){
        Emp singleBean = baseDao.getSingleBean("select emp_id empID, emp_name empName, emp_position empPosition, login_account loginAccount, login_password loginPassword from t_emp where emp_id = ?",
                Emp.class,
                1);

        System.out.println(singleBean);
    }

    @Test
    public void testGetBeanList(){
        List<Emp> beanList = baseDao.getBeanList("select emp_id empID, emp_name empName, emp_position empPosition, login_account loginAccount, login_password loginPassword from t_emp",
                Emp.class);
        System.out.println(beanList);
    }
    
    @Test
    public void testUpdate(){
        int emperor = baseDao.update("update t_emp set emp_position = ? where emp_id = ?",
                "minister",
                "3");
        System.out.println(emperor);
    }

    @Test
    public void testGetConnection(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);
    }

    @Test
    public void test1(){
        List<Memorials> allMemorialsDigest = new MemorialsServiceImpl().getAllMemorialsDigest();
        System.out.println(allMemorialsDigest);
    }
}
