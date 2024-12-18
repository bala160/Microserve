package com.example.product.controller;

import com.example.product.entity.Student;
import com.example.product.entity.UserPojo;
import com.example.product.repo.UserRepo;
import com.example.product.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SpringSecurityController {

    @Autowired
    public UserRepo userRepo;
    @Autowired
    public UserService userService;
    @GetMapping("/api")
    public String method(HttpServletRequest request) {
        return "security application called" + " " +request.getSession().getId();

    }

    @PostMapping("/post-api")
    public Student method2(@RequestBody Student s) {
        System.out.println("method2 called");
        return s;
    }

    @PostMapping("/register")
    public UserPojo addUser(@RequestBody UserPojo userPojo) {
        System.out.println("Adduser");
        return userService.register(userPojo);
    }

    @GetMapping("/csrf-token")
    public CsrfToken token(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
