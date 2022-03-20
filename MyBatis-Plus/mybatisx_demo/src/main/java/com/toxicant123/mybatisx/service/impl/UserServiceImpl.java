package com.toxicant123.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.toxicant123.mybatisx.pojo.User;
import com.toxicant123.mybatisx.service.UserService;
import com.toxicant123.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 13655
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-20 12:20:22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




