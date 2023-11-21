package com.example.bookmall.service.impl;

import com.example.bookmall.entity.User;
import com.example.bookmall.entity.UserExample;
import com.example.bookmall.mapper.UserMapper;
import com.example.bookmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void removeUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void modifyUser(User emp) {

    }

    @Override
    public void modifyRole(Integer id, String role) {
        String r="";
        System.out.println(role);
        if(role.equals("1")){
            r="ROLE_admin";
        }else{
            r="ROLE_user";
        }
        userMapper.modifyRole(id,r);
    }

    @Override
    public List<User> queryAll() {
        List<User> users = userMapper.selectByExample(null);
        return users;
    }

    @Override
    public List<User> selectByKey(String name) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike("%"+name+"%");
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public User getUser(String username) {

        return null;
    }

//    @Override
//    public List<Authority> getUserAuthority(String username) {
//
//        return null;
//    }
//
//
//    @Override
//    public List<User> selectByPage(int pageIndex) {
//        return null;
//    }
}
