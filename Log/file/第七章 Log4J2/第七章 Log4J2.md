# 第七章 Log4J2

Apache Log4j 2是对Log4j的升级版，参考了logback的一些优秀的设计，并且修复了一些问题，因此带来了一些重大的提升，主要有：

* 异常处理，在logback中，Appender中的异常不会被应用感知到，但是在log4j2中，提供了一些异常处理机制。
* 性能提升， log4j2相较于log4j 和logback都具有很明显的性能提升，后面会有官方测试的数据。
* 自动重载配置，参考了logback的设计，当然会提供自动刷新参数配置，最实用的就是我们在生产上可以动态的修改日志的级别而不需要重启应用。
* 无垃圾机制，log4j2在大部分情况下，都可以使用其设计的一套无垃圾机制，避免频繁的日志收集导致的jvm gc。

官网： https://logging.apache.org/log4j/2.x/

### 4.1 Log4j2入门

目前市面上最主流的日志门面就是SLF4J，虽然Log4j2也是日志门面，因为它的日志实现功能非常强大，性能优越。所以大家一般还是将Log4j2看作是日志的实现，Slf4j + Log4j2应该是未来的大势所趋。

1. 添加依赖

```xml
<dependencies>
    <!-- Log4j2 门面API-->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.11.1</version>
    </dependency>
    <!-- Log4j2 日志实现 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.11.1</version>
    </dependency>
</dependencies>
```

2. JAVA代码

```java
public class Log4j2Test {
    // 定义日志记录器对象
    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);
    
    @Test
    public void testQuick() throws Exception {
        LOGGER.fatal("fatal");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
```

3. 使用slf4j作为日志的门面,使用log4j2作为日志的实现

```xml
<dependencies>
    <!-- Log4j2 门面API-->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.11.1</version>
    </dependency>
    <!-- Log4j2 日志实现 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.11.1</version>
    </dependency>
    <!--使用slf4j作为日志的门面,使用log4j2来记录日志 -->
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
    </dependency>
    <!--为slf4j绑定日志实现 log4j2的适配器 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-slf4j-impl</artifactId>
        <version>2.10.0</version>
    </dependency>
</dependencies>
```

### 4.2 Log4j2配置

log4j2默认加载classpath下的 log4j2.xml 文件中的配置。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="warn" monitorInterval="5">
    <properties>
        <property name="LOG_HOME">D:/logs</property>
    </properties>
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] [%-5level] %c{36}:%L --- %m%n"/>
        </Console>
        <File name="file" fileName="${LOG_HOME}/myfile.log">
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %m%n"/>
        </File>
        <RandomAccessFile name="accessFile" fileName="${LOG_HOME}/myAcclog.log">
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %m%n"/>
        </RandomAccessFile>
        <RollingFile name="rollingFile" fileName="${LOG_HOME}/myrollog.log"
                     filePattern="D:/logs/$${date:yyyy-MM-dd}/myrollog-%d{yyyyMM-dd-HH-mm}-%i.log">
            <ThresholdFilter level="debug" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %msg%n"/>
            <Policies>
                <OnStartupTriggeringPolicy/>
                <SizeBasedTriggeringPolicy size="10 MB"/>
                <TimeBasedTriggeringPolicy/>
            </Policies>
            <DefaultRolloverStrategy max="30"/>
        </RollingFile>
    </Appenders>
    <Loggers>
        <Root level="trace">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

配置文件说明：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
    status="warn" 日志框架本身的输出日志级别
    monitorInterval="5" 自动加载配置文件的间隔时间，不低于5秒
-->
<Configuration status="warn" monitorInterval="5">

<!--
        集中配置属性进行管理
        使用时通过:${name}
-->
    <properties>
        <property name="LOG_HOME">D:/logs</property>
    </properties>

<!--
    日志处理
-->
    <Appenders>
<!--        控制台输出 appender-->
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] [%-5level] %c{36}:%L --- %m%n"/>
        </Console>

<!--        日志文件输出 appender-->
        <File name="file" fileName="${LOG_HOME}/myfile.log">
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %m%n"/>
        </File>
<!--        使用随机的读写流的日志文件输出 appender, 性能提高-->
        <RandomAccessFile name="accessFile" fileName="${LOG_HOME}/myAcclog.log">
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %m%n"/>
        </RandomAccessFile>

<!--        按照一定规则拆分的日志文件的appender-->
        <RollingFile name="rollingFile" fileName="${LOG_HOME}/myrollog.log"
                     filePattern="D:/logs/$${date:yyyy-MM-dd}/myrollog-%d{yyyyMM-dd-HH-mm}-%i.log">
<!--            日志级别的过滤器-->
            <ThresholdFilter level="debug" onMatch="ACCEPT" onMismatch="DENY"/>
            <PatternLayout pattern="[%d{yyyy-MM-dd HH:mm:ss.SSS}] [%-5level] %l %c{36} - %msg%n"/>
            <Policies>
<!--                在系统启动时，出发拆分规则，生产一个新的日志文件-->
                <OnStartupTriggeringPolicy/>
<!--                按照文件的大小拆分，10MB-->
                <SizeBasedTriggeringPolicy size="10 MB"/>
<!--                按照时间的节点进行拆分，规则根据filePattern定义的-->
                <TimeBasedTriggeringPolicy/>
            </Policies>
<!--            在同一个目录下，文件的个数限定为30个，超过进行覆盖-->
            <DefaultRolloverStrategy max="30"/>
        </RollingFile>
    </Appenders>

<!--    logger定义-->
    <Loggers>
<!--        使用rootLogger 配置，日志级别 level="trace"-->
        <Root level="trace">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

### 4.3 Log4j2异步日志

log4j2最大的特点就是异步日志，其性能的提升主要也是从异步日志中受益，我们来看看如何使用log4j2的异步日志。

* 同步日志

![img.png](img.png)

* 异步日志

![img_1.png](img_1.png)

Log4j2提供了两种实现日志的方式，一个是通过AsyncAppender，一个是通过AsyncLogger，分别对应前面我们说的Appender组件和Logger组件。

注意：配置异步日志需要添加依赖

```xml
<!--异步日志依赖-->
<dependency>
    <groupId>com.lmax</groupId>
    <artifactId>disruptor</artifactId>
    <version>3.3.4</version>
</dependency>
```

1. AsyncAppender方式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="warn">
    <properties>
        <property name="LOG_HOME">D:/logs</property>
    </properties>
    <Appenders>
        <File name="file" fileName="${LOG_HOME}/myfile.log">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
        </File>

        <!--        启用异步的appender-->
        <Async name="Async">
            <!--            指定一个appender-->
            <AppenderRef ref="file"/>
        </Async>
    </Appenders>
    <Loggers>
        <Root level="error">
            <!--            使用异步的appender-->
            <AppenderRef ref="Async"/>
        </Root>
    </Loggers>
</Configuration>
```

2. AsyncLogger方式

AsyncLogger才是log4j2 的重头戏，也是官方推荐的异步方式。它可以使得调用Logger.log返回的更快。你可以有两种选择：全局异步和混合异步。

* 全局异步就是，所有的日志都异步的记录，在配置文件上不用做任何改动，只需要添加一个log4j2.component.properties 配置

```properties
Log4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
```

* 混合异步就是，你可以在应用中同时使用同步日志和异步日志，这使得日志的配置方式更加灵活。

只需更改配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <properties>
        <property name="LOG_HOME">D:/logs</property>
    </properties>
    <Appenders>
        <File name="file" fileName="${LOG_HOME}/myfile.log">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
        </File>
        <Async name="Async">
            <AppenderRef ref="file"/>
        </Async>
    </Appenders>
    <Loggers>
        <AsyncLogger name="com.toxicant123" level="trace"
                     includeLocation="false" additivity="false">
            <AppenderRef ref="file"/>
        </AsyncLogger>
        <Root level="info" includeLocation="true">
            <AppenderRef ref="file"/>
        </Root>
    </Loggers>
</Configuration>
```

如上配置： com.toxicant123 日志是异步的，root日志是同步的。

使用异步日志需要注意的问题：
1. 如果使用异步日志，AsyncAppender、AsyncLogger和全局日志，不要同时出现。性能会和AsyncAppender一致，降至最低。
2. 设置includeLocation=false ，打印位置信息会急剧降低异步日志的性能，比同步日志还要慢。


