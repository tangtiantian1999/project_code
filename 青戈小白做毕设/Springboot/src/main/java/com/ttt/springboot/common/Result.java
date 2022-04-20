package com.ttt.springboot.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口统一返回包装类，所有的接口都返回result对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    public static Result sucess(){
        return new Result(Constants.CODE_200,"",null);
    }
    public static Result sucess(Object data){
        return new Result(Constants.CODE_200,"",data);
    }

    public static Result error(String code,String msg){
        return  new Result(code,msg,null);
    }

    public static Result error(){
        return  new Result(Constants.CODE_500,"系统错误",null);
    }
}
