package com.hannt.bo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class PersistentConfig {
    @Bean("dataSource")
    @Profile({"local", "default"})
    public DataSource localDataSource(){
        return null;
    }

    @Bean("dataSource")
    @Profile("dev")
    public DataSource devDataSource(){
        return null;
    }

    @Bean("dataSource")
    @Profile("real")
    public DataSource realDataSource(){
        return null;
    }
}
