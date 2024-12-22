package com.example.product.service;

import com.example.product.entity.UserPojo;
import com.example.product.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    JWTService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); //one way hashing can't able to decode
    public UserPojo register(UserPojo user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }


    public String verify(UserPojo user){
        System.out.println("verify method calling");
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(auth.isAuthenticated()){
           return jwtService.generateToken(user.getUsername());
        }
        return "fail";
    }

}
