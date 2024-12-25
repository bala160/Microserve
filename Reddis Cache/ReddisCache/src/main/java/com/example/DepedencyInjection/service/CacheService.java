package com.example.DepedencyInjection.service;

import com.example.DepedencyInjection.entity.CacheTable;
import com.example.DepedencyInjection.repository.CacheRepo;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @Autowired
    public CacheRepo cacheRepo;

    @Autowired
    private CacheManager cacheManager;
    public CacheTable saveDB(CacheTable cacheTable) {
        return cacheRepo.save(cacheTable);
    }

    @Cacheable(value = "cacheTable", key = "#id")
    public CacheTable fetchAPI(int id) {
        Cache cache = cacheManager.getCache("cacheTable");
        CacheTable cacheTable = cache.get(id, CacheTable.class);

        if (cacheTable != null) {
            System.out.println("Data fetched from cache: " + cacheTable);
        } else {
            System.out.println("Data fetched from DB/External source.");
        }
        return  cacheRepo.findById(id).orElseThrow(() -> new RuntimeException("Cache not found with ID: " + id));

    }

    @CacheEvict(value = "cacheTable", key = "#id")
    public void evictCache(int id) {
        System.out.println("Cache evicted for id: " + id);

    }

    @CachePut(value = "cacheTable", key = "#id")
    public CacheTable updateCache(int id, String apiname, String provider) {
        // This method simulates a database update and returns the updated entity
        CacheTable cacheTable = new CacheTable(id, apiname, provider);
        System.out.println("Cache updated for id: " + id);
        return cacheTable;
    }
}
