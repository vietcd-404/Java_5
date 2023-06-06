package com.example.ASM_JAVA5.filter;

import com.example.ASM_JAVA5.entity.*;
import com.example.ASM_JAVA5.service.OrderService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class AuthenticationFilter implements Filter {
    @Autowired
    private Cart cart;

    @Autowired
    private OrderService orderService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession(false);
        String loginURI = httpRequest.getContextPath() + "/login";
        String registerURI = httpRequest.getContextPath() + "/register";
        String forgotURI = httpRequest.getContextPath() + "/forgot";

//        System.out.println(httpRequest.getRemoteHost());
//        System.out.println(httpRequest.getRemotePort());
//        System.out.println(httpRequest.getRequestURI());

        boolean loggedIn = session != null && session.getAttribute("account") != null;
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean registerRequest = httpRequest.getRequestURI().equals(registerURI);
        boolean forgotRequest = httpRequest.getRequestURI().equals(forgotURI);



        if (loggedIn || loginRequest || registerRequest || forgotRequest) {
//            Account account = (Account) session.getAttribute("account");
//            Order order = new Order();
//            order.setAccount(account);
//            order.setOderDate(new Date());
//            order.setAddress(order.getAddress());
//            order.setStatus(order.getStatus());
//            List<OrderDetail> orderDetails = new ArrayList<>();
//            for (CartItem item : cart.getItems()) {
//                OrderDetail orderDetail = new OrderDetail();
//                orderDetail.setProduct(item.getProduct());
//                orderDetail.setPrice(item.getProduct().getPrice());
//                orderDetail.setQuantity(item.getQuantity());
//                orderDetails.add(orderDetail);
//            }
//
//            order.setOrderDetails(orderDetails);
//            orderService.insert(order);
//            cart.clearCart();
//            session.setAttribute("cart", cart);
            filterChain.doFilter(servletRequest, servletResponse);

        } else {
            httpResponse.sendRedirect(loginURI);
        }


    }

    @Override
    public void destroy() {

    }
}
