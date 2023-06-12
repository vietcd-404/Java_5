package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.Account;
import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.entity.Order;
import com.example.ASM_JAVA5.entity.OrderDetail;
import com.example.ASM_JAVA5.service.OrderDetailService;
import com.example.ASM_JAVA5.service.OrderService;
import com.example.ASM_JAVA5.viewModel.OrderDetailView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user/order-detail")
public class OrderDetailController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/view")
    public String viewInvoice(Model model, HttpSession session){
        Account account = (Account) session.getAttribute("account");
//       List<OrderDetailView> list =  orderDetailService.findAccountId(account.getId());
        List<OrderDetail> list = orderDetailService.getList();
       model.addAttribute("list",list);
       return "/user/invoice";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model, HttpSession session) {
//        Order order = orderService.findById(id);
//        order.setStatus(1);
//        orderService.update(id, order);
//        String v = this.viewInvoice(model,session);
//        return v;
        return "/admin/product/view";
    }
}
