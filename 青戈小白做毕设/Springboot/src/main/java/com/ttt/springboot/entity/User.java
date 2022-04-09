package com.ttt.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    //忽略某个字段不展示给前端
    @JsonIgnore
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
}
