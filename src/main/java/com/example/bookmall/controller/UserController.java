package com.example.bookmall.controller;

import com.example.bookmall.entity.User;
import com.example.bookmall.service.UserService;
import com.example.bookmall.service.impl.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private SendEmailService sendEmailService;
    @PostMapping("/user/signUp")
    public String addUser(String name, String pwd, String pwd2, Model model) {
        if (StringUtils.isEmpty(name)) {
            model.addAttribute("error", "用户名不能为空");
            return "user/sign";
        }
        if (StringUtils.isEmpty(pwd) | StringUtils.isEmpty(pwd2)) {
            model.addAttribute("error", "密码不能为空");
            return "user/sign";
        }
        if (!pwd.equals(pwd2)) {
            model.addAttribute("error", "两次密码不相同，注册失败！！");
            return "user/sign";
        } else {
            User user = new User();
            user.setUsername(name);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String pwds = encoder.encode(pwd);
            user.setPassword(pwds);
            String role="用户";
            user.setRole("ROLE_user");
//            邮件发送
            String to="1022681778@qq.com";
            String subject="网上书店通知";
            Context context=new Context();
            context.setVariable("username",name);
            context.setVariable("code","注册成功");
            context.setVariable("role",role);
            String emailTemplate = templateEngine.process("emailTemplate", context);
            sendEmailService.sendTemplateEmail(to,subject,emailTemplate);

            user.setValid(true);
            userService.addUser(user);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("");
            return "user/sign";
        }
    }

    @PostMapping("/editUser")
    public String editRole(String id, String role) {
        userService.modifyRole(Integer.parseInt(id), role);
        return "redirect:/Toadmin";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Integer id) {
        System.out.println(id);
        userService.removeUser(id);
        return "redirect:/Toadmin";
    }

    @PostMapping("/searchUser")
    public String searchUser(String name, Model model) {
        List<User> users = userService.selectByKey(name);
        model.addAttribute("users", users);
        return "admin/admin";
    }
}
