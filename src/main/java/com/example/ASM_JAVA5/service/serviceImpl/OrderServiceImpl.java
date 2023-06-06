package com.example.ASM_JAVA5.service.serviceImpl;

import com.example.ASM_JAVA5.entity.Order;


import java.util.List;

public interface OrderServiceImpl {
    List<Order> getList();

    Order insert(Order order);

    boolean delete(int id);

    Order update(Integer id, Order order);

    Order findById(int id);
}
