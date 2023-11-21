package com.example.bookmall.service;

import com.example.bookmall.entity.User;

import java.util.List;

public interface UserService {
    //添加
    public void addUser(User user);
    //删除
    public void removeUser(int id);
    //修改
    public void modifyUser(User emp);
    public void modifyRole(Integer id,String role);
    //查询所有信息
    public List<User> queryAll();
    //模糊查询
    List<User> selectByKey(String name);
//    使用唯一用户名查询用户信息
    User getUser(String username);
//    根据唯一用户名去查询用户权限
//    List<Authority> getUserAuthority(String username);
//    //分页查询
//    List<User> selectByPage(int pageIndex);
}
