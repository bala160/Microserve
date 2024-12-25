package com.example.DepedencyInjection.controller;

import com.example.DepedencyInjection.entity.CacheTable;
import com.example.DepedencyInjection.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CacheController {

    @Autowired
    public CacheService cacheService;

    @PostMapping("/Adding")
    public CacheTable method(@RequestBody CacheTable cacheTable) {
        return cacheService.saveDB(cacheTable);
    }

    @GetMapping("/FetchAPI/{id}")
    public CacheTable method2(@PathVariable int id) {
        return cacheService.fetchAPI(id);
    }

    @GetMapping("/DeleteAPICache/{id}")
    public ResponseEntity method3(@PathVariable int id) {
        cacheService.evictCache(id);
        return new ResponseEntity<>("Successfully removed data from cache", HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCache/{id}")
    public CacheTable updateCache(@PathVariable int id, @RequestBody CacheTable cacheTable) {
        // Update cache and the database record (simulated)
        return cacheService.updateCache(id, cacheTable.getApiname(), cacheTable.getProvider());
    }
}
