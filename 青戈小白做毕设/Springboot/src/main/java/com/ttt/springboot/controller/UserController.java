package com.ttt.springboot.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ttt.springboot.entity.User;
import com.ttt.springboot.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.list();
    }

    @PostMapping
    /*@RequestBody意思是将前台传过来的json数据映射成实体类*/
    public boolean insert(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

    @PostMapping("/del/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids){
        return userService.removeBatchByIds(ids);
    }

    /**
     * mybatis-plus分页以及模糊查询
     *需要注意的是Mybatis-plus分页方法返回的Ipage中数据使用records，所以在前端中需要修改一下
     * 当模糊查询数据为空时，不进行拼接，因为数据库中的字段可能为null值，查出来的数据可能会不对
     */
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                       @RequestParam Integer pageSize,
                                       @RequestParam(defaultValue = "") String username,
                                       @RequestParam(defaultValue = "") String email,
                                       @RequestParam(defaultValue = "") String address){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if(!"".equals(email)){
            queryWrapper.like("email",email);
        }
        if(!"".equals(address)){
            queryWrapper.like("address",address);
        }
        queryWrapper.orderByDesc("id");
        return userService.page(page,queryWrapper);
    }

    /*mybatis分页功能以及模糊查询
    * @RequestParam 接受？pageNum=1 这种方式传过来的数据
    * 具体实现细节在service里
    * */
/*    @GetMapping("page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username,
                                        @RequestParam String email,
                                        @RequestParam String address){
        return userService.findPage(pageNum,pageSize,username,email,address);
    }*/
}
