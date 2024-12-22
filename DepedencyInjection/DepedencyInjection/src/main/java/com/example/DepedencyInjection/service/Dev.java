package com.example.DepedencyInjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    @Autowired
    //@Qualifier("laptop")
    Computer computer;

    public void call() {
        computer.compile();
    }
}
