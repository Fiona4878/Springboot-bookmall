package com.example.bookmall.controller;

import com.example.bookmall.entity.*;
import com.example.bookmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BooksController {
    @Autowired
    BooksService booksService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PressService pressService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/category")
    public String category(Model model, HttpServletRequest request) {
//        获取所以分类;
        List<Books> allType = booksService.getAllType();
        model.addAttribute("types", allType);
        //获取全部作者
        List<Author> authors = authorService.queryAll();
        model.addAttribute("authors", authors);
        //获取全部出版社
        List<Press> allpress = pressService.getAllpress();
        model.addAttribute("press", allpress);
        return "com/category";
    }

    //具体的某个分类页面
    @RequestMapping(value = "/cate")
    public String cate(@RequestParam("id") String id, Model model, HttpServletRequest request) {
        List<Books> books = booksService.selectByType(id);
        model.addAttribute("prods", books);//添加一个值为"hello thymeleaf"的hello变量到视图
        //获取用户名
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());  // 取值
        map.put("message", request.getSession().getAttribute("session_user"));
        model.addAttribute("user", map.get("message"));
        return "com/all";
    }

    @RequestMapping(value = "/cateau")
    public String cateau(@RequestParam("au") int au, Model model, HttpServletRequest request) {
        List<Books> books = booksService.selectByAuthorId(au);
        model.addAttribute("prods", books);//添加一个值为"hello thymeleaf"的hello变量到视图

        //获取用户名
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());  // 取值
        map.put("message", request.getSession().getAttribute("session_user"));
        model.addAttribute("user", map.get("message"));

        return "com/all";
    }

    @RequestMapping(value = "/catepress")
    public String catepress(@RequestParam("id") int id, Model model, HttpServletRequest request) {
        List<Books> books = booksService.selectByPressId(id);
        model.addAttribute("prods", books);//添加一个值为"hello thymeleaf"的hello变量到视图

        //获取用户名
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());  // 取值
        map.put("message", request.getSession().getAttribute("session_user"));
        model.addAttribute("user", map.get("message"));

        return "com/all";
    }

    @PostMapping("/search")
    public String search(String text, Model model, HttpServletRequest request) {
        List<Books> books = booksService.selectByTB(text);
        model.addAttribute("prods", books);
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());  // 取值
        map.put("message", request.getSession().getAttribute("session_user"));
        model.addAttribute("user", map.get("message"));
        return "com/all";
    }

    @RequestMapping(value = "/detail")
    public String selectdetail(@RequestParam("id") int id, Model model, HttpServletRequest request) {
        Books books = booksService.selectByDetails(id);
        model.addAttribute("book", books);//添加一个值为"hello thymeleaf"的hello变量到视图
        return "com/detail";
    }

//    用户购买书籍 返回到我的书库
    @RequestMapping(value = "/buy")
    public String buy(@RequestParam("id") int id, Model model, Principal principal) {
        List<User> users = userService.selectByKey(principal.getName());
        Orders orders=new Orders();
        orders.setBookid(id);
        orders.setUserid(users.get(0).getId());
        orderService.addOrders(orders);
        List<Map> maps = orderService.queryAllByUid(users.get(0).getId());
        model.addAttribute("orders", maps);
        return "user/myorder";
    }

    @RequestMapping(value = "/deletebook")
    public String deletebook(@RequestParam("id") int id) {
        booksService.removeBooks(id);
        return "redirect:/all";
    }

    @PostMapping("/book/editBooks")
    public String editBookPrice(Integer id, String price, Model model) {
        System.out.println("编辑价格");
        booksService.modifyBooksPrice(price, id);
        return "redirect:/all";
    }

}
