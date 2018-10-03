package com.hannt.example.shop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

class ShopConfigurationTest {
    private static ApplicationContext context;

    @BeforeAll
    public static void setUp(){
        context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
    }

    @Test
    void aaa() {
        Product aaa = context.getBean("aaa", Product.class);

        assertNotNull(aaa);
        assertEquals("AAA", aaa.getName());
    }

    @Test
    void cdrw() {
        Product cdrw = context.getBean("cdrw", Product.class);

        assertNotNull(cdrw);
    }

    @Test
    void dvdrw() {
        Product dvdrw = context.getBean("dvdrw", Product.class);
        assertNotNull(dvdrw);
    }

    @Test
    void shoppingCart(){
        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);

        assertNotNull(cart1);
        assertNotNull(cart2);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);

        cart1.addItem(aaa);
        cart1.addItem(cdrw);

        System.out.println("Shopping cart 1 contains "+cart1.getItems());

        Product dvdrw = context.getBean("dvdrw", Product.class);
        cart2.addItem(dvdrw);
        System.out.println("Shopping cart 2 contains " + cart2.getItems() );
    }
}