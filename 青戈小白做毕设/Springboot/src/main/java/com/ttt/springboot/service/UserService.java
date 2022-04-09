package com.ttt.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttt.springboot.entity.User;
import com.ttt.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
    @Autowired
    UserMapper userMapper;


/*
    public List<User> findAll() {
        return userMapper.findAll();
    }
*/

    //这里的方法名称不能写save会重叠，然后报stackover什么什么的错
/*    public boolean saveUser(User user){
*//*        if(user.getId()==null)
            return save(user);
        else
            return updateById(user);*//*
        return saveOrUpdate(user);//mybatis-plus提供的方法
    }*/

/*
    public int save(User user) {
        if(user.getId()==null){//如果id为空则代表新增对象
            return userMapper.insert(user);
        }else{//如果id有值则代表更新对象
            return userMapper.update(user);
        }
    }
*/

    /*public Integer deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    *//*Map一个用来装数据总量，一个用来装该页的数据*//*
    public Map<String, Object> findPage(Integer pageNum,
                                        Integer pageSize,
                                        String username,
                                        String email,
                                        String address) {
        pageNum=(pageNum-1)*pageSize;//该页的数据起始位置下标
        Map<String,Object> res = new HashMap<>();
        username='%'+username+'%';
        email='%'+email+'%';
        address='%'+address+'%';
        List<User> data = userMapper.findPage(pageNum,pageSize,username,email,address);
        Integer total = selectTotal(username,email,address);
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    public Integer selectTotal(String username,String email,String address) {
        return userMapper.selectTotal(username,email,address);
    }*/
}
