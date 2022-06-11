# 第六章 Logback

Logback是由log4j创始人设计的另一个开源日志组件，性能比log4j要好。

官方网站：https://logback.qos.ch/index.html

Logback主要分为三个模块：
* logback-core：其它两个模块的基础模块
* logback-classic：它是log4j的一个改良版本，同时它完整实现了slf4j API
* logback-access：访问模块与Servlet容器集成提供通过Http来访问日志的功能

后续的日志代码都是通过SLF4J日志门面搭建日志系统，所以在代码是没有区别，主要是通过修改配置文件和pom.xml依赖

### 6.1 logback入门

1. 添加依赖

```xml
<dependencies>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.3</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
</dependencies>
```

2. java代码

```java
public class Example {
    //定义日志对象
    public final static Logger LOGGER = LoggerFactory.getLogger(LogBackTest.class);
    
    @Test
    public void testSlf4j(){
        //打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
```

### 6.2 logback配置

logback会依次读取以下类型配置文件：
* logback.groovy
* logback-test.xml
* logback.xml 如果均不存在会采用默认配置

1. logback组件之间的关系
  * Logger:日志的记录器，把它关联到应用的对应的context上后，主要用于存放日志对象，也可以定义日志类型、级别。
  * Appender:用于指定日志输出的目的地，目的地可以是控制台、文件、数据库等等。
  * Layout:负责把事件转换成字符串，格式化的日志信息的输出。在logback中Layout对象被封装在encoder中。
2. 基本配置信息

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!--
        日志输出格式：
        %-5level
        %d{yyyy-MM-dd HH:mm:ss.SSS}日期
        %c类的完整名称
        %M为method
        %L为行号
        %thread线程名称
        %m或者%msg为信息
        %n换行
    -->
    <!--
        格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度
        %msg：日志消息，%n是换行符
    -->
    <property name="pattern" value="%d{yyyy-MM-dd HH:mm:ss.SSS} %c [%thread] %-5level %msg%n"/>
    <!--
        Appender: 设置日志信息的去向,常用的有以下几个
        ch.qos.logback.core.ConsoleAppender (控制台)
        ch.qos.logback.core.rolling.RollingFileAppender (文件大小到达指定尺寸的时候产生一个新文件)
        ch.qos.logback.core.FileAppender (文件)
    -->
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <!--输出流对象 默认 System.out 改为 System.err-->
        <target>System.err</target>
        <!--日志格式配置-->
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
    </appender>
    <!--
    用来设置某一个包或者具体的某一个类的日志打印级别、以及指定<appender>。
    <loger>仅有一个name属性，一个可选的level和一个可选的addtivity属性
    name:
    用来指定受此logger约束的某一个包或者具体的某一个类。
    level:
    用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL 和
    OFF，
    如果未设置此属性，那么当前logger将会继承上级的级别。
    additivity:
    是否向上级loger传递打印信息。默认是true。
    <logger>可以包含零个或多个<appender-ref>元素，标识这个appender将会添加到这个
    logger
    -->
    <!--
    也是<logger>元素，但是它是根logger。默认debug
    level:用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL
    和 OFF，
    <root>可以包含零个或多个<appender-ref>元素，标识这个appender将会添加到这个
    logger。
    -->
    <root level="ALL">
        <appender-ref ref="console"/>
    </root>
</configuration>
```

3. FileAppender配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- 自定义属性 可以通过${name}进行引用-->
    <property name="pattern" value="[%-5level] %d{yyyy-MM-dd HH:mm:ss} %c %M %L [%thread] %m %n"/>
    <!--
    日志输出格式：
    %d{pattern}日期
    %m或者%msg为信息
    %M为method
    %L为行号
    %c类的完整名称
    %thread线程名称
    %n换行
    %-5level
-->
    <!-- 日志文件存放目录 -->
    <property name="log_dir" value="d:/logs"></property>
    <!--控制台输出appender对象-->
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <!--输出流对象 默认 System.out 改为 System.err-->
        <target>System.err</target>
        <!--日志格式配置-->
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
    </appender>
    <!--日志文件输出appender对象-->
    <appender name="file" class="ch.qos.logback.core.FileAppender">
        <!--日志格式配置-->
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
        <!--日志输出路径-->
        <file>${log_dir}/logback.log</file>
    </appender>
    <!-- 生成html格式appender对象 -->
    <appender name="htmlFile" class="ch.qos.logback.core.FileAppender">
        <!--日志格式配置-->
        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
            <layout class="ch.qos.logback.classic.html.HTMLLayout">
                <pattern>%level%d{yyyy-MM-dd HH:mm:ss}%c%M%L%thread%m</pattern>
            </layout>
        </encoder>
        <!--日志输出路径-->
        <file>${log_dir}/logback.html</file>
    </appender>
    <!--RootLogger对象-->
    <root level="all">
        <appender-ref ref="console"/>
        <appender-ref ref="file"/>
        <appender-ref ref="htmlFile"/>
    </root>
</configuration>
```

4. RollingFileAppender配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- 自定义属性 可以通过${name}进行引用-->
    <property name="pattern" value="[%-5level] %d{yyyy-MM-dd HH:mm:ss} %c %M %L [%thread] %m %n"/>
    <!--
    日志输出格式：
    %d{pattern}日期
    %m或者%msg为信息
    %M为method
    %L为行号
    %c类的完整名称
    %thread线程名称
    %n换行
    %-5level
    -->
    <!-- 日志文件存放目录 -->
    <property name="log_dir" value="d:/logs"></property>
    <!--控制台输出appender对象-->
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <!--输出流对象 默认 System.out 改为 System.err-->
        <target>System.err</target>
        <!--日志格式配置-->
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
    </appender>
    <!-- 日志文件拆分和归档的appender对象-->
    <appender name="rollFile"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!--日志格式配置-->
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
        <!--日志输出路径-->
        <file>${log_dir}/roll_logback.log</file>
        <!--指定日志文件拆分和压缩规则-->
        <rollingPolicy
                class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!--通过指定压缩文件名称，来确定分割文件方式-->
            <fileNamePattern>${log_dir}/rolling.%d{yyyy-MMdd}.log%i.gz</fileNamePattern>
            <!--文件拆分大小-->
            <maxFileSize>1MB</maxFileSize>
        </rollingPolicy>
    </appender>
    <!--RootLogger对象-->
    <root level="all">
        <appender-ref ref="console"/>
        <appender-ref ref="rollFile"/>
    </root>
</configuration>
```

5. Filter、异步日志和自定义Logger配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- 自定义属性 可以通过${name}进行引用-->
    <property name="pattern" value="[%-5level] %d{yyyy-MM-dd HH:mm:ss} %c %M %L [%thread] %m %n"/>
    <!--
        日志输出格式：
        %d{pattern}日期
        %m或者%msg为信息
        %M为method
        %L为行号
        %c类的完整名称
        %thread线程名称
        %n换行
        %-5level
    -->
    <!-- 日志文件存放目录 -->
    <property name="log_dir" value="d:/logs/"></property>
    <!--控制台输出appender对象-->
    <appender name="console" class="ch.qos.logback.core.ConsoleAppender">
        <!--输出流对象 默认 System.out 改为 System.err-->
        <target>System.err</target>
        <!--日志格式配置-->
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
    </appender>
    <!-- 日志文件拆分和归档的appender对象-->
    <appender name="rollFile"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <!--日志格式配置-->
        <encoder
                class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <pattern>${pattern}</pattern>
        </encoder>
        <!--日志输出路径-->
        <file>${log_dir}roll_logback.log</file>
        <!--指定日志文件拆分和压缩规则-->
        <rollingPolicy
                class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <!--通过指定压缩文件名称，来确定分割文件方式-->
            <fileNamePattern>${log_dir}rolling.%d{yyyy-MMdd}.log%i.gz</fileNamePattern>
            <!--文件拆分大小-->
            <maxFileSize>1MB</maxFileSize>
        </rollingPolicy>
        <!--filter配置-->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <!--设置拦截日志级别-->
            <level>error</level>
            <onMatch>ACCEPT</onMatch>
            <onMismatch>DENY</onMismatch>
        </filter>
    </appender>
    <!--异步日志-->
    <appender name="async" class="ch.qos.logback.classic.AsyncAppender">
        <appender-ref ref="rollFile"/>
    </appender>
    <!--RootLogger对象-->
    <root level="all">
        <appender-ref ref="console"/>
        <appender-ref ref="async"/>
    </root>
    <!--自定义logger additivity表示是否从 rootLogger继承配置-->
    <logger name="com.itheima" level="debug" additivity="false">
        <appender-ref ref="console"/>
    </logger>
</configuration>
```

6. 官方提供的log4j.properties转换成logback.xml

https://logback.qos.ch/translator/

### 6.3 logback-access的使用

logback-access模块与Servlet容器（如Tomcat和Jetty）集成，以提供HTTP访问日志功能。我们可以使用logback-access模块来替换tomcat的访问日志。

1. 将logback-access.jar与logback-core.jar复制到$TOMCAT_HOME/lib/目录下
2. 修改$TOMCAT_HOME/conf/server.xml中的Host元素中添加：

```xml
<Valve className="ch.qos.logback.access.tomcat.LogbackValve" />
```

3. logback默认会在$TOMCAT_HOME/conf下查找文件 logback-access.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!-- always a good activate OnConsoleStatusListener -->
    <statusListener
            class="ch.qos.logback.core.status.OnConsoleStatusListener"/>
    <property name="LOG_DIR" value="${catalina.base}/logs"/>
    <appender name="FILE"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_DIR}/access.log</file>
        <rollingPolicy
                class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>access.%d{yyyy-MM-dd}.log.zip</fileNamePattern>
        </rollingPolicy>
        <encoder>
            <!-- 访问日志的格式 -->
            <pattern>combined</pattern>
        </encoder>
    </appender>
    <appender-ref ref="FILE"/>
</configuration>
```

4. 官方配置： https://logback.qos.ch/access.html#configuration