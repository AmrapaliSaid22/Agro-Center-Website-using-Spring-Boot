package com.app.demospringbootregistrationform.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.demospringbootregistrationform.entity.User;
import com.app.demospringbootregistrationform.repo.UserRepo;
import com.app.demospringbootregistrationform.service.UserService;

@Controller
public class UserController {
  
    @Autowired
    private UserService service;
    @Autowired(required = true)
    private UserRepo repo;
    @GetMapping("/")
    public String register(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("user") User user){
        String result="error";
        System.out.println(user);
        if(user.getPassword().equals(user.getCpassword())){
            try {
                service.registeruser(user);
                result="login";
            } catch (Exception e) {
                result="error";
            }
        }
        return result;
        
    }

    @GetMapping("/log")
    public String login(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/userLogin")
    public String loginUser(@ModelAttribute("user") User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        String username=user.getUsername();
        Optional<User> userdata=repo.findById(username);
        //User userdata=this.repo.findbyusername(username);

        if(user.getPassword().equals(userdata.get().getPassword())){
            return "Homepage";
        }
        else{
            return "error";
        }
        
    }
}
