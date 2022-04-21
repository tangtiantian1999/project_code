package com.ttt.springboot.controller.tdo;

import lombok.Data;

/**
 * 专门用来接受前端登录请求的参数
 */
@Data
public class UserDto {
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String token;
}
