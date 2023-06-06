package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.Account;
import com.example.ASM_JAVA5.entity.Cart;
import com.example.ASM_JAVA5.entity.Order;
import com.example.ASM_JAVA5.service.CartService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String showCart(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "/user/cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam("productId") int productId) {
        cartService.addToCart(productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam("productId") int productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String showCheckout(Model model, HttpServletRequest request, HttpServletResponse response) {
//        Cart cart = cartService.getCart();
//        double totalPrice = cartService.calculateTotalPrice();
//        model.addAttribute("cart", cart);
//        model.addAttribute("totalPrice", totalPrice);
//        Integer accountId = (Integer) request.getAttribute("account");
//
//        return "/user/checkout";

    
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            Account account = (Account) session.getAttribute("account");
            int accountId = account.getId();
            Cart cart = cartService.getCart();
            double totalPrice = cartService.calculateTotalPrice();
            model.addAttribute("cart", cart);
            model.addAttribute("totalPrice", totalPrice);
            return "/user/checkout";
        } else {
            return null;
        }
    }

    @PostMapping("/checkout")
    public String checkout(ServletRequest servletRequest, ServletResponse servletResponse ) throws IOException {
        cartService.checkout(servletRequest,servletResponse);
        return "redirect:/home";
    }

}
