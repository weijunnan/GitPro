package com.example.spjdbc.JdbcController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcTmpController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("query")
    public List<Map<String, Object>> GetType() {

        List<Map<String, Object>> list = jdbcTemplate.queryForList("select *from jdbcnum");


        return list;
    }
}
