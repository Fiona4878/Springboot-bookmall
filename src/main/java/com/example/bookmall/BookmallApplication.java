package com.example.bookmall;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.example.bookmall.mapper")
@EnableCaching
public class BookmallApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookmallApplication.class, args);
    }

}
