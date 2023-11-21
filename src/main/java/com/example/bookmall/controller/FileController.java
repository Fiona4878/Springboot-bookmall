package com.example.bookmall.controller;


import com.example.bookmall.entity.Books;
import com.example.bookmall.entity.User;
import com.example.bookmall.service.BooksService;

import com.example.bookmall.service.OrderService;
import com.example.bookmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class FileController {
    @Autowired
    private BooksService booksService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "user/sign";
    }

    @GetMapping("/")
    public String toindex(Model model, HttpServletRequest request) {
        List<Books> books = booksService.queryAll();
        model.addAttribute("hello", books);
        return "index";
    }

    @GetMapping("/all")
    public String toAllBook(Model model) {
        List<Books> books = booksService.queryAll();
        model.addAttribute("prods", books);
        return "com/all";
    }

    @GetMapping("/Toadmin")
    public String toAdmin(Model model) {
        List<User> users = userService.queryAll();
        model.addAttribute("users", users);
        return "admin/admin";
    }
    @GetMapping("/myorders")
    public String toMyorders(Model model, Principal principal) {
        List<User> users = userService.selectByKey(principal.getName());
        List<Map> maps = orderService.queryAllByUid(users.get(0).getId());
        model.addAttribute("orders", maps);
        return "user/myorder";
    }
    @GetMapping("/orders")
    public String toorders(Model model) {
        List<Map> maps = orderService.queryAll();
        model.addAttribute("orders",maps);
        return "com/orders";
    }
}
