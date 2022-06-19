# 第一章 快速上手SpringBoot

SpringBoot技术由Pivotal团队研发制作，功能是加速Spring程序的开发，主要可分为下面两部分：

* Spring程序初始搭建过程
* Spring程序的开发过程

## 1.1 SpringBoot入门程序开发

### 1.1.1 方式一

步骤1：创建新模块，选择Spring Initializr，并配置模块相关基础信息

![img.png](img.png)

第3步点击Next时，Idea需要联网状态，如果不能正常联网，就无法正确到达右边的设置页

第5步选择java版本和你计算机上安装的JDK版本匹配即可，但是最低要求为JDK8或以上版本，推荐使用8或11

步骤②：选择当前模块需要使用的技术

![img_1.png](img_1.png)

左侧选择web，然后在中间选择Spring Web即可，选完右侧就出现了新的内容项，这就表示勾选成功了

步骤3：开发控制器类

```java
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getById(){
        System.out.println("springboot is running...");
        return "springboot is running...";
    }
}
```

入门案例制作的SpringMVC的控制器基于Rest风格开发，当然此处使用原始格式制作SpringMVC的程序也是没有问题的，上例中的@RestController与@GetMapping注解是基于Restful开发的典型注解

步骤4：运行自动生成的Application类

![img_2.png](img_2.png)

使用带main方法的java程序的运行形式来运行程序，运行完毕后，控制台输出上述信息

```text
访问路径 http://localhost:8080/books
```