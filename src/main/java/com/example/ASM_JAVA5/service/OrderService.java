package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.entity.Order;
import com.example.ASM_JAVA5.repository.OrderRepository;
import com.example.ASM_JAVA5.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getList() {
        return orderRepository.findAll();
    }

    @Override
    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean delete(int id) {
        orderRepository.deleteById(id);
        return true;
    }


    @Override
    public Order update(Integer id, Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }
}
