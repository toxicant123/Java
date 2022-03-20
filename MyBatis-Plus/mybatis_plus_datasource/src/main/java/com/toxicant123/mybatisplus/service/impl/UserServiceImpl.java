package com.toxicant123.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toxicant123.mybatisplus.mapper.UserMapper;
import com.toxicant123.mybatisplus.pojo.User;
import com.toxicant123.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-20 11:17
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
