package com.example.product.service;

import com.example.product.entity.UserPojo;
import com.example.product.entity.UserPrinciple;
import com.example.product.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserConfig implements UserDetailsService {

    @Autowired
    public UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserName :"+username);
        UserPojo user = userRepo.findByUsername(username);
        System.out.println(user.getUsername());
        if(user == null){
            System.out.println("User is not available in server");
        }

        return new UserPrinciple(user);
    }
}
