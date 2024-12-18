package com.example.product.repo;

import com.example.product.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserPojo,Integer> {

    UserPojo findByUsername(String userName);
}
