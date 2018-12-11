package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    //查找所有的用户
    public List<User> findall() throws Exception;
    //根据用户的Id查询一个用户
    public Optional<User> selectUserById(int id) throws Exception;
    //增加一个用户
    public void addUser(User user) throws Exception;
    //根据Id删除一个用户
    public void deleteById(int id) throws Exception;
    //对用户的信息进行修改
    public void updateUser(User user) throws Exception;

}
