package com.example.ASM_JAVA5.service;

import com.example.ASM_JAVA5.entity.*;
import com.example.ASM_JAVA5.repository.OrderRepository;
import com.example.ASM_JAVA5.repository.ProductRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private Cart cart;

    @Autowired
    private OrderService orderService;

    @Autowired
    HttpSession session;

    @Autowired
    private ProductRepository productRepository;

    public Cart getCart() {
        return cart;
    }

    public void addToCart(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        cart.addItem(product);
        session.setAttribute("cart", cart);
    }

    public void removeFromCart(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        cart.removeItem(product);
        session.setAttribute("cart", cart);
    }

    public void clearCart() {
        cart.clearCart();
        session.setAttribute("cart", cart);
    }

    public double calculateTotalPrice() {
        return cart.getTotalPrice();
    }

    public void checkout(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession(false);
        String loginURI = httpRequest.getContextPath() + "/login";
        String registerURI = httpRequest.getContextPath() + "/register";
        String forgotURI = httpRequest.getContextPath() + "/forgot";

        boolean loggedIn = session != null && session.getAttribute("account") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);
        boolean forgotRequest = httpRequest.getRequestURI().equals(forgotURI);

        if (loggedIn || loginRequest || registerRequest || forgotRequest) {
            // Lấy thông tin người dùng từ session
            Account account = (Account) session.getAttribute("account");
            String address = httpRequest.getParameter("address");
            Order order = new Order();
            order.setAccount(account);
            order.setOderDate(new Date());
            order.setAddress(address);
            order.setStatus(order.getStatus());
            List<OrderDetail> orderDetails = new ArrayList<>();
            for (CartItem item : cart.getItems()) {
                double totalPrice = 0.0;
                totalPrice += item.getProduct().getPrice() * item.getQuantity();
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(item.getProduct());
                orderDetail.setPrice(item.getProduct().getPrice());
                orderDetail.setQuantity(item.getQuantity());
                orderDetail.setTotal(totalPrice);
                orderDetails.add(orderDetail);
            }

            order.setOrderDetails(orderDetails);
            orderService.insert(order);
            for (OrderDetail orderDetail : orderDetails) {
                orderDetail.setOrder(order);
                orderDetailService.insert(orderDetail);
            }
            cart.clearCart();
            session.setAttribute("cart", cart);

        } else {
            httpResponse.sendRedirect(loginURI);
        }
//        Order order = new Order();
//        order.setAccount(order.getAccount());
//        order.setOderDate(new Date());
//        order.setAddress(order.getAddress());
//        order.setStatus(order.getStatus());
//        List<OrderDetail> orderDetails = new ArrayList<>();
//        for (CartItem item : cart.getItems()) {
//            OrderDetail orderDetail = new OrderDetail();
//            orderDetail.setProduct(item.getProduct());
//            orderDetail.setPrice(item.getProduct().getPrice());
//            orderDetail.setQuantity(item.getQuantity());
//            orderDetails.add(orderDetail);
//        }
//
//        order.setOrderDetails(orderDetails);
//        orderService.insert(order);
//        cart.clearCart();
//        session.setAttribute("cart", cart);
    }
}
