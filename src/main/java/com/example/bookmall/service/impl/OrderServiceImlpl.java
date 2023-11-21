package com.example.bookmall.service.impl;

import com.example.bookmall.entity.Orders;
import com.example.bookmall.mapper.OrdersMapper;
import com.example.bookmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImlpl implements OrderService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public void addOrders(Orders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public void removeOrders(int id) {
        ordersMapper.deleteByPrimaryKey(id);
    }

//    通过订单号查询订单
    @Override
    public Orders selectById(Integer id) {
        Orders orders = ordersMapper.selectByPrimaryKey(id);
        return orders;
    }
//    通过用户id查询用户的购买书籍
    @Override
    public List<Map> queryAllByUid(Integer id) {
        List<Map> orders = ordersMapper.queryAllByUid(id);
        return orders;
    }

    @Override
    public List<Map> queryAllByUname(String name) {
        List<Map> maps = ordersMapper.queryAllByUname(name);
        return maps;
    }

    @Override
    public List<Map> queryAll() {
        List<Map> orders = ordersMapper.quarryAll();
        return orders;
    }
}
