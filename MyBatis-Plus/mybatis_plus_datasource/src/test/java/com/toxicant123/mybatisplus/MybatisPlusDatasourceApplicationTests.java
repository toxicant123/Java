package com.toxicant123.mybatisplus;

import com.toxicant123.mybatisplus.pojo.Product;
import com.toxicant123.mybatisplus.pojo.User;
import com.toxicant123.mybatisplus.service.ProductService;
import com.toxicant123.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusDatasourceApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

   @Test
   public void test1(){
       User byId = userService.getById(1);
       Product byId1 = productService.getById(1);
       System.out.println(byId);
       System.out.println(byId1);
   }

}
