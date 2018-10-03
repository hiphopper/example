package com.hannt.example.shop;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Product {
    private String name;
    private double price;
}
