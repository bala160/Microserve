package com.example.DepedencyInjection.service;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

    @Override
    public void compile() {
        System.out.println("Compile using Laptop");
    }
}
