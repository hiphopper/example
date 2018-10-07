package com.hannt.example.shop;

import lombok.Getter;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@Lazy
public class ShoppingCart {
    @Getter private List<Product> items = new ArrayList<>();

    public void addItem(Product item){
        items.add(item);
    }
}
