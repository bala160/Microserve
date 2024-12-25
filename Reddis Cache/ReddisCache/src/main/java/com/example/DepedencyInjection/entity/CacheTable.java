package com.example.DepedencyInjection.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "CACHE")
public class CacheTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will auto-generate the id if it's an auto-increment field in the database
    private int id;

    private String apiname;

    private String provider;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApiname() {
        return apiname;
    }

    public void setApiname(String apiname) {
        this.apiname = apiname;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public CacheTable(int id, String apiname, String provider) {
        this.id = id;
        this.apiname = apiname;
        this.provider = provider;
    }
    public CacheTable() {}
}
