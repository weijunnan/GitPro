package com.example.spjdbc.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@EnableAutoConfiguration
@RestController
public class Hello {

    @Autowired
    private DataSource dataSource;


    @GetMapping("hello")
    String hello() {
        System.out.println(dataSource);

        return "I can do it !";
    }

}
