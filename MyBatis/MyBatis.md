# MyBatis

## 一、MyBatis简介

### 1. MyBatis历史

MyBatis最初是Apache的一个开源项目**iBatis**, 2010年6月这个项目由Apache Software Foundation迁移到了Google Code。随着开发团队转投Google Code旗下， iBatis3.x正式更名为MyBatis。代码于2013年11月迁移到Github。

iBatis一词来源于“internet”和“abatis”的组合，是一个基于Java的持久层框架。 iBatis提供的持久层框架包括SQL Maps和Data Access Objects（DAO）。

### 2. MyBatis特性

1. MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架 
2. MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集 
3. MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录 
4. MyBatis 是一个 半自动的ORM（Object Relation Mapping）框架

### 3. MyBatis下载

MyBatis下载地址：https://github.com/mybatis/mybatis-3

![img.png](img.png)

![img_1.png](img_1.png)

### 4. 和其它持久化层技术对比

* JDBC
  - SQL 夹杂在Java代码中耦合度高，导致硬编码内伤
  - 维护不易且实际开发需求中 SQL 有变化，频繁修改的情况多见
  - 代码冗长，开发效率低
* Hibernate 和 JPA
  - 操作简便，开发效率高
  - 程序中的长难复杂 SQL 需要绕过框架
  - 内部自动生产的 SQL，不容易做特殊优化
  - 基于全映射的全自动框架，大量字段的 POJO 进行部分映射时比较困难。
  - 反射操作太多，导致数据库性能下降
* MyBatis
  - 轻量级，性能出色
  - SQL 和 Java 编码分开，功能边界清晰。Java代码专注业务、SQL语句专注数据
  - 开发效率稍逊于HIbernate，但是完全能够接受

## 二、搭建MyBatis

### 1. 开发环境

IDE：idea 2021.3

构建工具：maven 3.8.1

MySQL版本：MySQL 5.7

MyBatis版本：MyBatis 3.5.7

### 2. 创建maven工程

1. 打包方式：jar

2. 引入依赖

```xml
<dependencies>
  <!-- Mybatis核心 -->
  <dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.7</version>
  </dependency>
  
  <!-- junit测试 -->
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
    
  </dependency>
  <!-- MySQL驱动 -->
  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.3</version>
  </dependency>
</dependencies>
```

## 3、创建MyBatis的核心配置文件

> 习惯上命名为[mybatis-config.xml](MyBatis_demo1/src/main/resources/mybatis-config.xml)，这个文件名仅仅只是建议，并非强制要求。将来整合Spring之后，这个配置文件可以省略，所以大家操作时可以直接复制、粘贴。
> 
> 核心配置文件主要用于配置连接数据库的环境以及MyBatis的全局配置信息
> 
> 核心配置文件存放的位置是src/main/resources目录下



















