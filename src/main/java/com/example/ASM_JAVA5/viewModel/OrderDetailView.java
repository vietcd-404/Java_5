package com.example.ASM_JAVA5.viewModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailView {
    private String productName;
    private double productPrice;
    private String productBrand;
    private String address;
    private Date orderDate;
    private int quantity;
    private double total;
    private int status;
}
