package com.toxicant123.mybatisplus;

import com.toxicant123.mybatisplus.mapper.UserMapper;
import com.toxicant123.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-17 10:57
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    UserMapper userMapper;
    
    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    
    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(29);
        user.setName("张三");
        user.setEmail("zhangsan@163.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
        System.out.println(user);
    }
    
    @Test
    public void testDelete(){
        //通过id删除数据
        int i = userMapper.deleteById(1504302767798841346L);
        System.out.println(i);
    }
    
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",29);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }
    
    @Test
    public void testDeleteBatchIds(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        int i = userMapper.deleteBatchIds(integers);
        System.out.println(i);
    }
    
    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1L);
        user.setEmail("qwer@qq.com");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testCustom(){
        Map<String, Object> stringObjectMap = userMapper.selectMapById(1L);
        System.out.println(stringObjectMap);
    }

}
