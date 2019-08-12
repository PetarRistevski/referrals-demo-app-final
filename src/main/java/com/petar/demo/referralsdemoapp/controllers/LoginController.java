package com.petar.demo.referralsdemoapp.controllers;


import com.petar.demo.referralsdemoapp.model.User;
import com.petar.demo.referralsdemoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
   @Autowired
  private UserService userService;

    @GetMapping("/login")
    public String showLogin(){
        return "login";
    }
    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @RequestMapping("/register")
    public String showRegister(Model model){
        User theUser = new User();
        model.addAttribute("user",theUser);
        return "register";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("users", userService.findAll());
        userService.save(user);
        return "success";
    }
    @GetMapping("/success")
    public String  successPage(){
        return "success";
    }
}
