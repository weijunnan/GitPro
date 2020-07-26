package com.example.spjdbc.configdatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDataSource {


    @Bean
    /*
    结合第三方组件的绑定，配置Druid数据源
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource dataSource() {

        return new DruidDataSource();
    }
}
