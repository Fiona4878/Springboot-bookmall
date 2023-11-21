package com.example.bookmall.controller;

import com.example.bookmall.entity.User;
import com.example.bookmall.service.OrderService;
import com.example.bookmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @GetMapping("deleteOrder")
    public String deleteUser(Integer id, Principal principal, Model model){
        List<User> users = userService.selectByKey(principal.getName());
        orderService.removeOrders(id);
        List<Map> maps = orderService.queryAllByUid(users.get(0).getId());
        model.addAttribute("orders", maps);
        return "user/myorder";
    }
    @GetMapping("deleteOrders")
    public String deleteOrders(Integer id, Principal principal, Model model){
        orderService.removeOrders(id);
        List<Map> maps = orderService.queryAll();
        model.addAttribute("orders", maps);
        return "com/orders";
    }
    @PostMapping("searchOrders")
    public String searchOrders(String name, Model model){
        List<User> users = userService.selectByKey(name);
        List<Map> maps=new ArrayList<>();
       for(int i=0;i<users.size();i++){
           List<Map> map = orderService.queryAllByUid(users.get(i).getId());
           for(int j=0;j<map.size();j++){
               maps.add(map.get(j));
           }
       }

        model.addAttribute("orders", maps);
        return "com/orders";
    }
}
