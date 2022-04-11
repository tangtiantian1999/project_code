package com.ttt.springboot.service.impl;

import com.ttt.springboot.entity.User;
import com.ttt.springboot.mapper.UserMapper;
import com.ttt.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 哼哼哼
 * @since 2022-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
