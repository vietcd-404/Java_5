package com.example.ASM_JAVA5.repository;

import com.example.ASM_JAVA5.entity.Account;
import com.example.ASM_JAVA5.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Modifying
    @Query(
            value = "INSERT INTO orders (account_id, address, order_date) VALUES (:account_id, :address, :order_date)",
            nativeQuery = true)
    void add(@Param("account_id") Integer accountId, @Param("address") String address, @Param("order_date") Date orderDate);
}
