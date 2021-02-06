package com.example.autumn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.autumn.mapper.dao")
@SpringBootApplication
public class AutumnApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutumnApplication.class, args);
    }

}
