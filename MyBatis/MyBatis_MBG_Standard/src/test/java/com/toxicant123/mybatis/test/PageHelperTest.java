package com.toxicant123.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.toxicant123.mybatis.mapper.EmpMapper;
import com.toxicant123.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-16 16:04
 */
public class PageHelperTest {

    static EmpMapper mapper;

    static {
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession(true);
        mapper = sqlSession.getMapper(EmpMapper.class);
    }

    /**
     * limit index,pageSize
     * index：当前页的起始索引
     * pageSize：每页显示的条数
     * pageNum：当前页的页码
     * index = (pageNum - 1) * pageSize
     *
     * 使用MyBatis的分页插件实现分页功能:
     * 1. 需要在查询功能之前开启分页
     * pageHelper.startPage(int pageNum, int pageSize);
     * 2. 在查询功能之后获取分页相关信息
     * PageInfo<Emp>page = new PageInfo<>(list,5);
     * list表示分页数据
     * 5表示当前导航分页的数量
     */

    @Test
    public void testPageHelper(){
        Page<Emp> page = PageHelper.startPage(1, 4);
        List<Emp> emps = mapper.selectByExample(null);
        PageInfo<Emp> empPageInfo = new PageInfo<>(emps,5);
        System.out.println(emps);

    }
}
