package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.entity.OrderDetail;
import com.example.ASM_JAVA5.repository.OrderDetailRepository;
import com.example.ASM_JAVA5.viewModel.OrderDetailView;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public OrderDetail insert(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public List<OrderDetail> getList() {
        return orderDetailRepository.findAll();
    }

//    public List<OrderDetailView> findAccountId(Integer id){
//        return orderDetailRepository.findAccountId(id);
//    }

}
