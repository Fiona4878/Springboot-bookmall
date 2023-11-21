package com.example.bookmall;

import com.example.bookmall.entity.Author;
import com.example.bookmall.entity.AuthorExample;
import com.example.bookmall.mapper.AuthorMapper;
import com.example.bookmall.service.AuthorService;
import com.example.bookmall.service.OrderService;
import com.example.bookmall.service.impl.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmallApplicationTests {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private OrderService orderService;
    @Test
    public void main1() {
   String to="";
   String subject="网上书店注册邮件";
        Context context=new Context();
        context.setVariable("username","注册名");
        context.setVariable("code","注册成功");
        String emailTemplate_vercode = templateEngine.process("emailTemplate_vercode", context);
        sendEmailService.sendTemplateEmail(to,subject,emailTemplate_vercode);
    }
    @Test
    public void main(){
        String to="1022681778@qq.com";
        String subject="网上书店通知";
        Context context=new Context();
        context.setVariable("username","name");
        context.setVariable("code","注册成功");
        String emailTemplate = templateEngine.process("emailTemplate", context);
        sendEmailService.sendTemplateEmail(to,subject,emailTemplate);

    }

}
