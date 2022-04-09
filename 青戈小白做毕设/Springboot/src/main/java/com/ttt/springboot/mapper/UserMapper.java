package com.ttt.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ttt.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

   /* @Select("select * from sys_user")
    List<User> findAll();

    @Insert("insert into sys_user(username,password,nickname,email,phone,address) " +
            "values(#{username},#{password},#{nickname},#{email},#{phone},#{address})")
    int insert(User user);


    int update(User user);

    @Delete("delete from sys_user where id=#{id}")
    *//*传过来的参数需要用@Param指定其名称，这个id必须和上面#{}中的一样*//*
    Integer deleteById(Integer id);

    @Select("select * from sys_user where username like #{username}" +
            " and email like #{email} and address like #{address} limit #{pageNum},#{pageSize}")
    List<User> findPage(Integer pageNum, Integer pageSize, String username, String email, String address);

    @Select("select count(*) from sys_user where username like #{username}" +
            "and email like #{email} and address like #{address}")
    Integer selectTotal(String username,String email,String address);*/
}
