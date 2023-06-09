package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.entity.Product;
import com.example.ASM_JAVA5.service.OrderService;
import com.example.ASM_JAVA5.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/product")
public class OrderController {


    @Autowired
    private ProductService productService;

    @GetMapping("/view")
    public String view(Model model,
                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(name = "pageSize", required = false, defaultValue = "8") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Product> page = productService.getPage(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("list", page.getContent());
//        List<Product> list = productService.getList();
//        model.addAttribute("list", list);
        int previousPage = Math.max(1, pageNum - 1);
        int nextPage = Math.min(page.getTotalPages(), pageNum + 1);

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("previousPage", previousPage);
        model.addAttribute("nextPage", nextPage);

        return "/user/shop";
    }

    @GetMapping("/detail/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/user/detail";
    }


}
