package com.example.bookmall.service;

import com.example.bookmall.entity.Books;

import java.util.List;

public interface BooksService {
    //获取全部分类
    public List<Books> getAllType();
    //添加
    public void addBooks(Books books);
    //删除
    public void removeBooks(int id);
    //修改
    public void modifyBooks(Books emp);
    //修改价格
    public void modifyBooksPrice(String price,Integer id);
    //查询所有图书信息
    public List<Books> queryAll();
    //模糊查询
    List<Books> selectByKey(String name);

    List<Books> selectByType(String name);

    List<Books> selectById(Integer id);
    List<Books> selectByAuthorId(Integer id);
    List<Books> selectByPressId(Integer id);
    List<Books> selectByTB(String text);
    Books selectByDetails(Integer id);
                //分页查询
    List<Books> selectByPage(int pageIndex);
}
