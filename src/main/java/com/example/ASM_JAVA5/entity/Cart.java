package com.example.ASM_JAVA5.entity;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Product product) {
        // Kiểm tra xem sản phẩm đã có trong giỏ hàng hay chưa
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                // Nếu đã có, tăng số lượng sản phẩm lên
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }

        // Nếu chưa có, tạo một CartItem mới và thêm vào giỏ hàng
        CartItem newItem = new CartItem(product, "ok" ,1,9000);
        items.add(newItem);
    }

    public void removeItem(Product product) {
        // Xóa CartItem tương ứng với sản phẩm khỏi giỏ hàng
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == product.getId()) {
                iterator.remove();
                return;
            }
        }
    }

    public void clearCart() {
        // Xóa tất cả CartItem trong giỏ hàng
        items.clear();
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (CartItem item : items) {
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        return totalPrice;
    }
}
