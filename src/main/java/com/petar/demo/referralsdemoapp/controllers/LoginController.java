package com.petar.demo.referralsdemoapp.controllers;


import com.petar.demo.referralsdemoapp.model.User;
import com.petar.demo.referralsdemoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Random;

@Controller
public class LoginController {
   @Autowired
  private UserService userService;

    @RequestMapping("/login")
    public String showLogin(Model model){
        User theUser = new User();
        model.addAttribute("user",theUser);
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
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        user.setAuto_generated_code(generatedString);
        userService.save(user);
        return "success";
    }


    @PostMapping("/login-attempt")
    public String loginUser(@ModelAttribute("user") User user, Model model){
        try {


            Optional<User> foundUser = userService.findByUsername(user.getUsername());
            if (foundUser.isPresent()) {
                User theFoundUser = foundUser.get();
                if (theFoundUser.getCode_to_register() != null) {
                    return "logged-with-discount";
                } else {
                    return "logged-without-discount";
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
            return "error-page";
        }
        return "error-page";
    }


    @GetMapping("/success")

    public String  successPage( ){


        return "success";
    }
}
