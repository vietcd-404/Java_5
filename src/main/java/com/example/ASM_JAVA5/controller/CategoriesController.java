package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.Account;
import com.example.ASM_JAVA5.entity.Categories;
import com.example.ASM_JAVA5.service.CategoriesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoriesController {
//    @GetMapping("/categories")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("home");
//        modelAndView.addObject("message","Hello wold");
//        return modelAndView;
//    }

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("account", new Account());
        List<Categories> list = categoriesService.getList();
        model.addAttribute("list", list);
        model.addAttribute("categories", new Categories());
        return "/admin/categories";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("categories") Categories categories, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            List<Categories> list = categoriesService.getList();
            model.addAttribute("list", list);
            return "/admin/categories";
        }
        categoriesService.insert(categories);
        return "redirect:/admin/categories/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        categoriesService.delete(id);
        return "redirect:/admin/categories/view";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @Valid @ModelAttribute("categories") Categories categories) {
        categoriesService.update(id, categories);
        return "redirect:/admin/categories/view";
    }

    @GetMapping("/edit/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("categories", new Categories());
        Categories categories = categoriesService.findById(id);
        model.addAttribute("categoriesList", categories);
        List<Categories> list = categoriesService.getList();
        model.addAttribute("list", list);
        return "/admin/categories";
    }

}
