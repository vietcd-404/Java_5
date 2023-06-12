package com.example.ASM_JAVA5.repository;

import com.example.ASM_JAVA5.entity.OrderDetail;
import com.example.ASM_JAVA5.viewModel.OrderDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

//    @Query(value = "SELECT product.name, product.price, product.brand, orders.address,orders.order_date, order_detail.quantity, order_detail.total, orders.status FROM order_detail INNER JOIN orders ON order_detail.order_id= orders.id INNER JOIN product ON order_detail.product_id= product.id INNER JOIN account ON account.id= orders.account_id where account.id = ?1",nativeQuery = true)
//    List<OrderDetail> findAccountId(Integer accountId);

//    @Query("SELECT product.name, product.price, product.brand, orders.address, orders.orderDate, orderDetail.quantity, orderDetail.total, orders.status "
//            + "FROM OrderDetail orderDetail "
//            + "JOIN orderDetail.order orders "
//            + "JOIN orderDetail.product product "
//            + "JOIN orders.account account "
//            + "WHERE account.id = :accountId")
//    List<OrderDetailView> findAccountId(@Param("accountId") Integer accountId);

}
