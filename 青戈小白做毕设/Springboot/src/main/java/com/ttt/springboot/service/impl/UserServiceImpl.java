package com.ttt.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ttt.springboot.common.Constants;
import com.ttt.springboot.controller.tdo.UserDto;
import com.ttt.springboot.entity.User;
import com.ttt.springboot.exception.ServiceException;
import com.ttt.springboot.mapper.UserMapper;
import com.ttt.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttt.springboot.utils.TokenUtils;
import org.springframework.stereotype.Service;

import java.lang.invoke.ConstantCallSite;

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

    @Override
    public UserDto login(UserDto userDto) {
        User one = getUserInfo(userDto);
        /*注意这个判断密码是否正确的是业务异常，不能写在try里面不然throw出去的600或被500catch到*/
        if(one!=null){
            BeanUtil.copyProperties(one,userDto,true);
            String token = TokenUtils.genToken(one.getId().toString(),one.getPassword());
            userDto.setToken(token);
            return userDto;
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }

    @Override
    public User register(UserDto userDto) {
        User one = getUserInfo(userDto);
        if(one==null){
            one = new User();
            BeanUtil.copyProperties(userDto,one,true);
            save(one);
        }else {
            throw new ServiceException(Constants.CODE_600,"用户已存在");
        }
        return one;
    }

    public User getUserInfo(UserDto userDto){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDto.getUsername());
        queryWrapper.eq("password",userDto.getPassword());
        User one;
        /*如果数据库中查询到多条用户名密码相同的数据，不合理统一返回false*/
        try{
            one = getOne(queryWrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        return one;
    }
}
