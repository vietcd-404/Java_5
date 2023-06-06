package com.example.ASM_JAVA5.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Product product;
    private String name;
    private int quantity;
    private double price;
}
