package com.example.DepedencyInjection.repository;

import com.example.DepedencyInjection.entity.CacheTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheRepo extends JpaRepository<CacheTable,Integer> {
}
