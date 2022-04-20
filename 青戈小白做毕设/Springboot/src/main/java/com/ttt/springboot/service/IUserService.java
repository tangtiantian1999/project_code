package com.ttt.springboot.service;

import com.ttt.springboot.controller.tdo.UserDto;
import com.ttt.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 哼哼哼
 * @since 2022-04-09
 */
public interface IUserService extends IService<User> {

    UserDto login(UserDto user);

    User register(UserDto user);
}
