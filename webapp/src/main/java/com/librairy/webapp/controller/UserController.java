package com.librairy.webapp.controller;

import com.librairy.webapp.model.JwtRequest;
import com.librairy.webapp.model.User;
import com.librairy.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public String inscrpition(Model model){
        User user = new User();
        JwtRequest request= new JwtRequest();
        model.addAttribute("user", user);
        model.addAttribute("request", request);
        return "SignIn";
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute User user){
        User savedUser = userService.createUser(user);
        return "redirect:/";
    }
}
