package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.entity.OrderDetail;
import com.example.ASM_JAVA5.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetail insert(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }
}
