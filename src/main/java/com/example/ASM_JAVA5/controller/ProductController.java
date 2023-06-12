package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.Account;
import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.entity.Product;
import com.example.ASM_JAVA5.service.CategoriesService;
import com.example.ASM_JAVA5.service.ProductService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    @Autowired
    ServletContext context;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("account", new Account());
        List<Product> list = productService.getList();
        model.addAttribute("list", list);
        List<Categories> list1 = categoriesService.getList();
        model.addAttribute("listCategories", list1);
        return "/admin/product";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("product") Product product,
                      BindingResult result,
                      RedirectAttributes attributes,
                      @RequestParam("imageProduct") MultipartFile file, Model model) {
        if (result.hasErrors()) {
            List<Product> list = productService.getList();
            model.addAttribute("list", list);
            List<Categories> list1 = categoriesService.getList();
            model.addAttribute("listCategories", list1);
            return "/admin/product";
        }
        //logic upload file
        String fileOriginal = file.getOriginalFilename();
        String fileDest = context.getRealPath("/upload/" + fileOriginal);
        System.out.println(fileDest);

        try {
            file.transferTo(new File(fileDest));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileOriginal);
        productService.insert(product);
        return "redirect:/admin/product/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/admin/product/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @ModelAttribute("product") Product product, BindingResult result,
                         RedirectAttributes attributes,
                         @RequestParam("imageProduct") MultipartFile file,Model model) {
        if (result.hasErrors()) {
            List<Product> list = productService.getList();
            model.addAttribute("list", list);
            List<Categories> list1 = categoriesService.getList();
            model.addAttribute("listCategories", list1);
            return "/admin/product";
        }
        //logic upload file
        String fileOriginal = file.getOriginalFilename();
        String fileDest = context.getRealPath("/upload/" + fileOriginal);
        System.out.println(fileDest);

        try {
            file.transferTo(new File(fileDest));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImage(fileOriginal);
        productService.update(id, product);
        return "redirect:/admin/product/view";
    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model,@RequestParam("imageProduct") MultipartFile file) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        List<Product> list = productService.getList();
        model.addAttribute("list", list);
        model.addAttribute("image",file);
        List<Categories> list1 = categoriesService.getList();
        model.addAttribute("listCategories", list1);
        return "/admin/product";
    }
}
