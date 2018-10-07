package com.hannt.example.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    private ApplicationContext context;
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext("com.hannt.example.shop");
        Product product = context.getBean("aaa", Product.class);
        shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.addItem(product);
    }

    @Test
    void checkout() throws IOException {
        Cashier cashier = context.getBean("cashier", Cashier.class);
        cashier.checkout(shoppingCart);
    }
}