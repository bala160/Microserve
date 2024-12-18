package com.example.product.service;

import com.example.product.entity.UserPojo;
import com.example.product.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public UserPojo register(UserPojo user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
