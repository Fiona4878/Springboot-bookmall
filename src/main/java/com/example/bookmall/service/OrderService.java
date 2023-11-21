package com.example.bookmall.service;

import com.example.bookmall.entity.Books;
import com.example.bookmall.entity.Orders;

import java.util.List;
import java.util.Map;


public interface OrderService {
    //添加
    public void addOrders(Orders orders);
    //删除
    public void removeOrders(int id);

    Orders selectById(Integer id);

    //根据uid找到我的所有订单
    public List<Map> queryAllByUid(Integer id) ;

    public List<Map> queryAllByUname(String name) ;
    //找出所有订单
    public List<Map> queryAll();

}
