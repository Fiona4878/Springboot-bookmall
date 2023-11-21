package com.example.bookmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

//开启安全支持
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    //    @Override
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////        选择定义密码加密算法
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
////        内存认证使用这个密码加密
////        authenticationManagerBuilder.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
//////                注册一个身份，并且密码需要加密
////                .withUser("user").password(bCryptPasswordEncoder.encode("user")).roles("common")
////                .and()
////                .withUser("admin").password(bCryptPasswordEncoder.encode("admin")).roles("common");
//
////        使用JDBC认证
////        查询客户
////        System.out.println("jdbc");
////        String usql = "select username,password,age from user where username = ?";
//////        查询客户对应的身份
////        String asql = "select u.username ,a.t_authority from user u,authority a,relation r where r.user_id=u.id and r.authority_id=a.id and u.username=?";
////        authenticationManagerBuilder.jdbcAuthentication().passwordEncoder(bCryptPasswordEncoder)
////                .dataSource(dataSource)
////                .usersByUsernameQuery(usql)
////                .authoritiesByUsernameQuery(asql);
//
//    }
//        jdbc身份认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        编码器
        String userSQl = "select username,password,valid from user where username=?";
        String authoritySQL = "select username,role from user where username=?";
        auth.jdbcAuthentication().passwordEncoder(encoder).dataSource(dataSource)
                .usersByUsernameQuery(userSQl)
                .authoritiesByUsernameQuery(authoritySQL);
    }

    //    //    权限管理
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/user/signUp").permitAll()
                .antMatchers("/js/**", "/css/**", "/bootstrap/**").permitAll()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/**/*.jpg", "/**/*.png", "/**/*.js").permitAll()
                .anyRequest().authenticated()//任何请求，登录后可以访问
                .and()
                .formLogin();

//    登录页面控制
        http.formLogin()
                .loginPage("/userLogin").permitAll()
                .defaultSuccessUrl("/")
                .failureUrl("/userLogin?error");
        http.logout()
                .logoutUrl("/mylogout")
                .logoutSuccessUrl("/");
        http.csrf().disable();
    }

}
