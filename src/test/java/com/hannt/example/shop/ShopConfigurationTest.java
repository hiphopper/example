package com.hannt.example.shop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShopConfigurationTest {
    private static ApplicationContext context;

    @BeforeAll
    public static void setUp(){
        context = new AnnotationConfigApplicationContext(ShopConfiguration.class);
    }

    @Test
    void discountProperties() throws IOException {
        Resource resource = new ClassPathResource("example/discounts.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);

        System.out.println("And don't forget our discounts!");
        System.out.println(properties);
    }

    @Test
    void messageSource(){
        String alert = context.getMessage("alert.checkout", null, Locale.US);
        Date date = new Date();
        String inventoryAlert = context.getMessage("alert.inventory.checkout", new Object[]{"[DVD-RW 3.0]", date.toString()}, Locale.US);

        assertEquals("A shopping cart has been checked out.", alert);
        assertEquals(String.format("A shopping cart with %s has been checked out at %s.", new Object[]{"[DVD-RW 3.0]", date.toString()}), inventoryAlert);
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
    void bannerLoader(){
        BannerLoader bl = context.getBean("bannerLoader", BannerLoader.class);
        assertNotNull(bl);
    }

    @Test
    void shoppingCart(){
        ShoppingCart cart1 = getShoppingCart(context);
        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);

        assertNotNull(cart1);
        assertNotNull(cart2);

        System.out.println("Shopping cart 1 contains "+cart1.getItems());

        Product dvdrw = context.getBean("dvdrw", Product.class);
        cart2.addItem(dvdrw);
        System.out.println("Shopping cart 2 contains " + cart2.getItems() );
    }

    @Test
    void cashier() throws IOException{
        ShoppingCart cart1 = getShoppingCart(context);

        Cashier cashier = context.getBean("cashier", Cashier.class);
        cashier.checkout(cart1);
    }

    private ShoppingCart getShoppingCart(ApplicationContext context){
        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(context.getBean("aaa", Product.class));
        cart1.addItem(context.getBean("cdrw", Product.class));

        return cart1;
    }
}