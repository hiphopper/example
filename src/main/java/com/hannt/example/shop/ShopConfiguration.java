package com.hannt.example.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hannt.example.shop")
public class ShopConfiguration {

    @Bean
    public Product aaa(){
        return new Battery("AAA", 2.5, true);
    }

    @Bean
    public Product cdrw(){
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);

        return p2;
    }

    @Bean
    public Product dvdrw(){
        Disc p2 = new Disc("DVD-RW", 3.0);
        p2.setCapacity(700);

        return p2;
    }
}
