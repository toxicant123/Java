package com.toxicant123.mybatis.mapper;

/**
 * <p>
 *     MyBatis面向接口编程的两个一致：<br>
 *     1. 映射文件的namespace要和mapper接口的全类名保持一致<br>
 *     2. 映射文件中SQL语句的id要和mapper接口中的方法名一致
 * </p>
 *
 * <p>
 *     表--实体类--mapper接口--映射文件
 * </p>
 *
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-10 22:18
 */
public interface UserMapper {

    /**
     * 添加用户信息
     * @return
     */
    int insertUser();
}
