package com.toxicant123.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toxicant123.mybatisplus.mapper.UserMapper;
import com.toxicant123.mybatisplus.pojo.User;
import com.toxicant123.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2022-03-17 14:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
