package com.toxicant123;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-07-02 9:49
 */
//1. 定义数据模型封装yaml文件中对应的数据
//2. 定义为spring管控的bean
@Component
//3. 指定加载的数据
@ConfigurationProperties("datasource")
public class MyDataSource {
    private String driver;

    private String url;

    private String username;

    private String password;

    public MyDataSource() {
    }

    public MyDataSource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyDataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
