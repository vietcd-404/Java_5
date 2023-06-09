package com.example.ASM_JAVA5.controller;

import com.example.ASM_JAVA5.entity.Account;
import com.example.ASM_JAVA5.service.AccountService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String showLoginPage(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("pass") String password,
                        HttpSession session,Model model) {
        Account account = accountService.login(username, password);

        if (account != null) {
            session.setAttribute("account", account);
            return "redirect:/home";
        }

            model.addAttribute("message","Tài khoản hoặc mật khẩu sai");
            return "login";




    }

    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("account");
        if (account != null) {

            model.addAttribute("account", account);
            return "/user/home";
        }
        return "login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("account", new Account());
        return "dangKy";
    }

    @PostMapping("/register")
    public String add(@Valid @ModelAttribute("account") Account account, BindingResult result) {
        if (result.hasErrors()) {
            return "dangKy";
        }
        account.setAvatar(null);
        account.setRole(1);
        accountService.insert(account);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/forgot")
    public String showForgot(Model model) {

        return "forgot";
    }
}
