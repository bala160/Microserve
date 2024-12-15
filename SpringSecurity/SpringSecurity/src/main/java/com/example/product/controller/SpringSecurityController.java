package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SpringSecurityController {

    @GetMapping("/api")
    public String method(){
        return "security application called";

    }
}
