package com.example.bookmall.service;

import com.example.bookmall.entity.Author;

import java.util.List;

public interface AuthorService {
        //获取全部作者
        public List<Author> getAllAuthor();
        //添加
        public void addAuthor(Author author);
        //删除
        public void removeAuthor(int id);
        //修改
        public void modifyAuthor(Author emp);
        //查询所有
        public List<Author> queryAll();
        //模糊查询
        List<Author> selectByKey(String name);
        //分页查询
        List<Author> selectByPage(int pageIndex);
}
