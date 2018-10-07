package com.hannt.example.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

import javax.annotation.PreDestroy;

@Configuration
@ComponentScan("com.hannt.example.shop")
@PropertySource("classpath:example/discounts.properties")
public class ShopConfiguration {
    @Value("${endofyear.discount:0}")
    private double specialEndofyearDiscountField;

    @Value("classpath:example/banner.txt")
    private Resource banner;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =
                new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:example/messages");
        messageSource.setCacheSeconds(60);
        return messageSource;
    }

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
        Disc p2 = new Disc("DVD-RW", specialEndofyearDiscountField);
        p2.setCapacity(700);

        return p2;
    }

    @Bean
    public BannerLoader bannerLoader(){
        BannerLoader bl = new BannerLoader();
        bl.setBanner(banner);
        return bl;
    }

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier(){
        String path = System.getProperty("java.io.tmpdir")+"/cashier";
        Cashier c1 = new Cashier();
        c1.setPath(path);
        c1.setFileName("checkout");
        c1.setMessageSource(messageSource());

        return c1;
    }
}
