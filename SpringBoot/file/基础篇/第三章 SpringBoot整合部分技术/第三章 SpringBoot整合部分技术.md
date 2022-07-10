# 第三章 SpringBoot整合部分技术

SpringBoot对于其他技术有很强的整合能力，本章将整合如下几种技术：

- JUnit
- MyBatis
- MyBatis-Plus
- Druid

## 3.1 整合JUnit

SpringBoot技术的定位是用于简化开发，简化的程度相当大，例如：

不使用SpringBoot技术时，Spring整合JUnit的操作方式：

```JAVA
//加载spring整合junit专用的类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//指定对应的配置信息
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTestCase {
    //注入需要测试的对象
    @Autowired
    private AccountService accountService;
    @Test
    public void testGetById(){
        //执行要测试的对象对应的方法
        System.out.println(accountService.findById(2));
    }
}
```

其中核心代码是两个注解，第一个注解@RunWith是设置Spring专用于测试的类运行器，第二个注解@ContextConfiguration是用来设置Spring核心配置文件或配置类的

这两个注解的信息较为固定，SpringBoot便针对这点进行简化，能使用默认值的使用默认值，具体如下：

```JAVA
@SpringBootTest
class Springboot04JunitApplicationTests {
    //注入需要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //执行要测试的对象对应的方法
        bookDao.save();
        System.out.println("two...");
    }
}
```

如果想自定义引导类有两种方式，第一种方式使用属性的形式进行，在注解@SpringBootTest中添加classes属性指定配置类

```JAVA
@SpringBootTest(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {
    //注入需要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //执行要测试的对象对应的方法
        bookDao.save();
        System.out.println("two...");
    }
}
```

第二种方式回是仍然使用@ContextConfiguration注解

```JAVA
@SpringBootTest
@ContextConfiguration(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {
    //注入需要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //执行要测试的对象对应的方法
        bookDao.save();
        System.out.println("two...");
    }
}
```